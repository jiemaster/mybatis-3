/**
 *    Copyright 2009-2015 the original author or authors.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
package org.apache.ibatis.scripting.xmltags;

/**
 * 典型的组合模式
 * Mybatis 在处理动态 sql 时，会将动态 SQL 标签解析为 SqlNode
 * 多个 SqlNode 对象通过组合的方式组合成属性结构供上层使用
 * @author Clinton Begin
 */
public interface SqlNode {
  /**
   * 根据用户传入的实参，解析 SqlNode 所表示的动态 sql 内容，并将解析后的 sql 片段追加到 DynamicContext.sqlBuilder 中
   * 通过 sqlBuilder.toString() 得到一条完整可执行的 sql 语句
   *
   * @param context
   * @return boolean
   */
  boolean apply(DynamicContext context);
}
