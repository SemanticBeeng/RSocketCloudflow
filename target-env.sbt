/*
 * The `pipelinesDockerRegistry` and `pipelinesDockerRepository` settings specify
 * the Docker registry (e.g. hostname) and repository (e.g. path on that host)
 * that the Pipelines sbt plugin uses for pushing application Docker images.
 *
 * Example:
 *
 * pipelinesDockerRegistry := Some("foo.com")
 * pipelinesDockerRepository := Some("bar/baz")
 *
 * This will cause your application Docker images to be pushed as:
 *
 * `foo.com/bar/baz/[image name]:[tag]`
 *
 * In multi-project SBT setups, please prefix both values with `ThisBuild / `, e.g.:
 *
 * ThisBuild / pipelinesDockerRegistry := Some("foo.com")
 * ThisBuild / pipelinesDockerRepository := Some("bar/baz")
 *
 * The sbt plugin expects you to have logged in to the specified registry using
 * the `docker login` command.
 */
//ThisBuild / cloudflowDockerRegistry := Some("docker.io")
//ThisBuild / cloudflowDockerRepository := Some("lightbend")

ThisBuild / cloudflowDockerRegistry := Some("acrsparksdp.azurecr.io")
ThisBuild / cloudflowDockerRepository := Some("sdp-data-lakehouse-collection-app")