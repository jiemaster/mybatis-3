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
 *
 */
package org.apache.ibatis.reflection;

/**
 * Comments by wendaojie
 *
 * 设计目的： 提升 Reflector 初始化速度， 对 Reflector 进行类缓存
 * DefaultReflectorFactory 是默认实现，内部维护一个 ConcurrentHashMap<Class<?>,
 * Reflector> 缓存其创建的所有 Reflector 对象
 *
 */
public interface ReflectorFactory {

  boolean isClassCacheEnabled();

  void setClassCacheEnabled(boolean classCacheEnabled);

  Reflector findForClass(Class<?> type);
}