package db

import config.data.PostgreSQLConfig

trait DatabaseMigrator[F[_]] {
  def migrate(config: PostgreSQLConfig): F[Int]
}
