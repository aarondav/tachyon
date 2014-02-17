/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package tachyon.client;

import java.io.IOException;

/**
 * Different read types for a TachyonFile. 
 */
public enum ReadType {
  /**
   * Read the file and but do not cache it explicitly.
   */
  NO_CACHE(1),
  /**
   * Read the file and cache it.
   */
  CACHE(2),
  /**
   * Cache based on whether the file is set to cache on read.
   */
  DEFAULT(3);

  private final int mValue;

  private ReadType(int value) {
    mValue = value;
  }

  public int getValue() {
    return mValue;
  }

  public boolean isCache(boolean cacheByDefault) {
    return this == CACHE || (this == DEFAULT && cacheByDefault);
  }

  public static ReadType getOpType(String op) throws IOException {
    if (op.equals("NO_CACHE")) {
      return NO_CACHE;
    } else if (op.equals("CACHE")) {
      return CACHE;
    } else if (op.equals("DEFAULT")) {
      return DEFAULT;
    }

    throw new IOException("Unknown ReadType : " + op);
  }
}
