import Versions._
import sbt._

object Dependencies {

  val rsocketCore           = "io.rsocket"          % "rsocket-core"                      % RSocketVersion
  val rsocketTransport      = "io.rsocket"          % "rsocket-transport-netty"           % RSocketVersion
  val rsocketLocal          = "io.rsocket"          % "rsocket-transport-local"           % RSocketVersion
  val rsocketBalancer       = "io.rsocket"          % "rsocket-load-balancer"             % RSocketVersion

  val argona                = "org.agrona"          % "Agrona"                            % argonaVersion

  val reactorCore           = "io.projectreactor"   % "reactor-core"                      % Versions.reactorCore
  val reactorKafka          = "io.projectreactor.kafka" % "reactor-kafka"                 % Versions.reactorKafka
  val kafka                 = "org.apache.kafka"    %% "kafka"                            % kafkaVersion
  val curator               = "org.apache.curator"  % "curator-test"                      % curatorVersion
  val commonIO              = "commons-io"          % "commons-io"                        % commonIOVersion

  val chronicle             = "net.openhft"         % "chronicle-queue"                   % chronicleVersion

  val slf4                  = "org.slf4j"           % "slf4j-api"                         % SLFVersion
  val logback               = "ch.qos.logback"      % "logback-classic"                   % LogBackVersion

  val marshallers           = "com.typesafe.akka"   %% "akka-http-spray-json"             % marshallersVersion

  val akkastreamLibs            = Seq(
    "com.typesafe.akka" %% "akka-stream",
    "com.typesafe.akka" %% "akka-protobuf",
    "com.typesafe.akka" %% "akka-protobuf-v3"
    ).map(_ % akkaVersion)

  val akkaGRPCLibs = Seq(
    "com.lightbend.akka.grpc" %% "akka-grpc-runtime" % "2.1.0"
  )

  val typesafeConfig        = "com.typesafe"        %  "config"                           % TypesafeConfigVersion
  val ficus                 = "com.iheart"          %% "ficus"                            % FicusVersion

  val scalaTest             = "org.scalatest"       %% "scalatest"                        % scaltestVersion    % "test"

}
