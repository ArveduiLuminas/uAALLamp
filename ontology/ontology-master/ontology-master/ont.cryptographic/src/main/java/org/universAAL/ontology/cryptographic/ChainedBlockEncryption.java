/*******************************************************************************
 * Copyright 2016 Universidad Politécnica de Madrid UPM
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ******************************************************************************/
package org.universAAL.ontology.cryptographic;

import java.util.ArrayList;
import java.util.List;


/**
 * Ontological representation of ChainedBlockEncryption in the cryptographic ontology. 
 * Methods included in this class are the mandatory ones for representing an
 * ontological concept in Java classes for the universAAL platform. In addition
 * getters and setters for properties are included.
 * 
 * @author 
 * @author Generated by the OntologyUML2Java transformation of AAL Studio
 */
public abstract class ChainedBlockEncryption extends BlockEncryption {
  public static final String MY_URI = CryptographicOntology.NAMESPACE
    + "ChainedBlockEncryption";
  public static final String PROP_CHAIN_MODE = CryptographicOntology.NAMESPACE
    + "chainMode";
  public static final String PROP_SIMPLE = CryptographicOntology.NAMESPACE
    + "simple";


  public ChainedBlockEncryption () {
    super();
  }
  
  public ChainedBlockEncryption (String uri) {
    super(uri);
  }

  public String getClassURI() {
    return MY_URI;
  }
  
  public int getPropSerializationType(String propURI) {
    if (PROP_CHAIN_MODE.equals(propURI))
      return PROP_SERIALIZATION_FULL;
    if (PROP_SIMPLE.equals(propURI))
      return PROP_SERIALIZATION_FULL;
    return super.getPropSerializationType(propURI);
  } 

  public boolean isWellFormed() {
	return super.isWellFormed() 
      && hasProperty(PROP_CHAIN_MODE)
      && hasProperty(PROP_SIMPLE);
  }

  public SimpleBlockEncryption getSimple() {
    return (SimpleBlockEncryption)getProperty(PROP_SIMPLE);
  }		

  public void setSimple(SimpleBlockEncryption newPropValue) {
    if (newPropValue != null)
      changeProperty(PROP_SIMPLE, newPropValue);
  }		

  public ChainMode[] getChainMode() {
    Object propList = getProperty(PROP_CHAIN_MODE);
    if (propList instanceof List)
      return (ChainMode[]) ((List) propList).toArray(new ChainMode[0]);
    else if (propList != null)
      return new ChainMode[] {(ChainMode)propList}; // Handle special case of a single item not contained in a list
    return new ChainMode[0];
  }

  public void addChainMode(ChainMode newValue) {
    Object propList = getProperty(PROP_CHAIN_MODE);
    List newList;
    if (propList instanceof List)
      newList = (List)propList;
    else {
      newList = new ArrayList();
      if (propList != null)
        newList.add(propList); // Handle special case of a single previous item not contained in a list
    }
    newList.add(newValue);
    changeProperty(PROP_CHAIN_MODE, newList);
  }
  

  public void setChainMode(ChainMode[] propertyValue) {
    List propList = new ArrayList(propertyValue.length);
    for (int i = 0; i < propertyValue.length; i++) {
      propList.add(propertyValue[i]);
    }
    changeProperty(PROP_CHAIN_MODE, propList);
  }

}
