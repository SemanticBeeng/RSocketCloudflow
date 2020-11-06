package com.lightbend.sensordata.rsocket.ingress

import cloudflow.akkastream.{ Server, _ }
import cloudflow.examples.sensordata.rsocket.avro._
import cloudflow.streamlets._
import cloudflow.streamlets.avro._
import com.lightbend.rsocket.dataconversion.SensorDataConverter
import io.rsocket._
import io.rsocket.core.RSocketServer
import io.rsocket.frame.decoder.PayloadDecoder
import io.rsocket.transport.netty.server.WebsocketServerTransport
import reactor.core.publisher._

class BinaryFireAndForget extends AkkaServerStreamlet {

  val out = AvroOutlet[SensorData]("out")

  def shape = StreamletShape.withOutlets(out)

  override def createLogic() = new BinaryFireAndForgetStreamletLogic(this, out)
}

// Create logic
class BinaryFireAndForgetStreamletLogic(server: Server, outlet: CodecOutlet[SensorData])
  (implicit context: AkkaStreamletContext) extends ServerStreamletLogic(server) {

  override def run(): Unit = {
    val writer = sinkRef(outlet)
    // Create server
    RSocketServer.create(SocketAcceptor.forFireAndForget((payload: Payload) ⇒ {
      // Get message and write to sink
      SensorDataConverter(payload.getData).map(writer.write)
      payload.release()
      Mono.empty()
    }))
      .payloadDecoder(PayloadDecoder.ZERO_COPY)
      .bind(WebsocketServerTransport.create("0.0.0.0", containerPort))
      .subscribe
    println(s"Bound RSocket server to port $containerPort")
  }
}
