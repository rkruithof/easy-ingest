/**
 * Copyright (C) 2015 DANS - Data Archiving and Networked Services (info@dans.knaw.nl)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package nl.knaw.dans.easy

import org.json4s.DefaultFormats

package object ingest {

  implicit val formats: DefaultFormats.type = DefaultFormats

  val CONFIG_FILENAME = "cfg.json"
  val FOXML_FILENAME = "fo.xml"
  val PLACEHOLDER_FOR_DMO_ID = "$sdo-id"

  type ObjectName = String
  type Pid = String
  type Predicate = String
  type ConfigDictionary = Map[ObjectName, DOConfig]
  type PidDictionary = Map[ObjectName, Pid]

  case class DatastreamSpec(contentFile: String = "",
                            dsLocation: String = "",
                            dsID: String = "",
                            mimeType: String = "application/octet-stream",
                            controlGroup: String = "M",
                            checksumType: String = "",
                            checksum: String = "")
  case class Relation(predicate: Predicate,
                      objectSDO: ObjectName = "",
                      `object`: Pid = "",
                      isLiteral: Boolean = false)
  case class DOConfig(namespace: String,
                      datastreams: List[DatastreamSpec],
                      relations: List[Relation])
}