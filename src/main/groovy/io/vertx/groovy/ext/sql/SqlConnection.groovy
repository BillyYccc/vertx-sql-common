/*
 * Copyright 2014 Red Hat, Inc.
 *
 * Red Hat licenses this file to you under the Apache License, version 2.0
 * (the "License"); you may not use this file except in compliance with the
 * License.  You may obtain a copy of the License at:
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */

package io.vertx.groovy.ext.sql;
import groovy.transform.CompileStatic
import io.vertx.lang.groovy.InternalHelper
import io.vertx.core.json.JsonArray
import io.vertx.ext.sql.UpdateResult
import io.vertx.ext.sql.ResultSet
import io.vertx.core.AsyncResult
import io.vertx.core.Handler
/**
 * Represents the <code>JdbcConnection</code> which is obtained from the <code>JdbcService</code>.
 *
 * @author <a href="mailto:nscavell@redhat.com">Nick Scavelli</a>
 */
@CompileStatic
public class SqlConnection {
  final def io.vertx.ext.sql.SqlConnection delegate;
  public SqlConnection(io.vertx.ext.sql.SqlConnection delegate) {
    this.delegate = delegate;
  }
  public Object getDelegate() {
    return delegate;
  }
  /**
   * Sets the auto commit flag for this connection. True by default. Set to false if you want
   *
   * @param autoCommit the autoCommit flag, true by default.
   * @param resultHandler
   * @see java.sql.Connection#setAutoCommit(boolean)
   */
  public SqlConnection setAutoCommit(boolean autoCommit, Handler<AsyncResult<Void>> resultHandler) {
    this.delegate.setAutoCommit(autoCommit, resultHandler);
    return this;
  }
  /**
   * Executes the given SQL statement
   *
   * @param sql the SQL to execute. For example <code>CREATE TABLE IF EXISTS table ...</code>
   * @param resultHandler the handler which is called once this operation completes.
   * @see java.sql.Statement#execute(String)
   */
  public SqlConnection execute(String sql, Handler<AsyncResult<Void>> resultHandler) {
    this.delegate.execute(sql, resultHandler);
    return this;
  }
  /**
   * Executes the given SQL <code>SELECT</code> statement which returns the results of the query.
   *
   * @param sql the SQL to execute. For example <code>SELECT * FROM table ...</code>.
   * @param resultHandler the handler which is called once the operation completes. It will return a list of <code>JsonObject</code>'s
   * which represent the ResultSet. So column names are keys, and values are of course values.
   *
   * @see java.sql.Statement#executeQuery(String)
   * @see java.sql.PreparedStatement#executeQuery(String)
   */
  public SqlConnection query(String sql, Handler<AsyncResult<ResultSet>> resultHandler) {
    this.delegate.query(sql, resultHandler);
    return this;
  }
  /**
   * Executes the given SQL <code>SELECT</code> prepared statement which returns the results of the query.
   *
   * @param sql the SQL to execute. For example <code>SELECT * FROM table ...</code>.
   * @param params these are the parameters to fill the statement. Pass null if
   * the statement is not a prepared statement.
   * @param resultHandler the handler which is called once the operation completes. It will return a list of <code>JsonObject</code>'s
   * which represent the ResultSet. So column names are keys, and values are of course values.
   *
   * @see java.sql.Statement#executeQuery(String)
   * @see java.sql.PreparedStatement#executeQuery(String)
   */
  public SqlConnection queryWithParams(String sql, List<Object> params, Handler<AsyncResult<ResultSet>> resultHandler) {
    this.delegate.queryWithParams(sql, params != null ? new io.vertx.core.json.JsonArray(params) : null, resultHandler);
    return this;
  }
  /**
   * Executes the given SQL statement which may be an <code>INSERT</code>, <code>UPDATE</code>, or <code>DELETE</code>
   * statement.
   *
   * @param sql the SQL to execute. For example <code>INSERT INTO table ...</code>
   * @param resultHandler the handler which is called once the operation completes.
   *
   * @see java.sql.Statement#executeUpdate(String)
   * @see java.sql.PreparedStatement#executeUpdate(String)
   */
  public SqlConnection update(String sql, Handler<AsyncResult<UpdateResult>> resultHandler) {
    this.delegate.update(sql, resultHandler);
    return this;
  }
  /**
   * Executes the given prepared statement which may be an <code>INSERT</code>, <code>UPDATE</code>, or <code>DELETE</code>
   * statement with the given parameters
   *
   * @param sql the SQL to execute. For example <code>INSERT INTO table ...</code>
   * @param params these are the parameters to fill the statement. Pass null if
   * the statement is not a prepared statement.
   * @param resultHandler the handler which is called once the operation completes.
   *
   * @see java.sql.Statement#executeUpdate(String)
   * @see java.sql.PreparedStatement#executeUpdate(String)
   */
  public SqlConnection updateWithParams(String sql, List<Object> params, Handler<AsyncResult<UpdateResult>> resultHandler) {
    this.delegate.updateWithParams(sql, params != null ? new io.vertx.core.json.JsonArray(params) : null, resultHandler);
    return this;
  }
  /**
   * Closes the connection. Important to always close the connection when you are done so it's returned to the pool.
   *
   * @param handler the handler called when this operation completes.
   */
  public void close(Handler<AsyncResult<Void>> handler) {
    this.delegate.close(handler);
  }
  /**
   * Commits all changes made since the previous commit/rollback.
   *
   * @param handler the handler called when this operation completes.
   */
  public SqlConnection commit(Handler<AsyncResult<Void>> handler) {
    this.delegate.commit(handler);
    return this;
  }
  /**
   * Rolls back all changes made since the previous commit/rollback.
   *
   * @param handler the handler called when this operation completes.
   */
  public SqlConnection rollback(Handler<AsyncResult<Void>> handler) {
    this.delegate.rollback(handler);
    return this;
  }

  static final java.util.function.Function<io.vertx.ext.sql.SqlConnection, SqlConnection> FACTORY = io.vertx.lang.groovy.Factories.createFactory() {
    io.vertx.ext.sql.SqlConnection arg -> new SqlConnection(arg);
  };
}
