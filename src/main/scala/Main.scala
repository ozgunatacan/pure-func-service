import cats.effect.IOApp
import cats.effect.IO
import cats.effect._
import cats.implicits._
import cats.effect.ExitCode
import db.FlywayDatabaseMigrator
object Main extends IOApp {
  def run(args: List[String]): IO[ExitCode] =
    for {
      cfg <- config.load[IO]
      _ <- new FlywayDatabaseMigrator[IO]().migrate(cfg.postgreSql)
    } yield ExitCode.Success
}
