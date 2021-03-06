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

import org.universAAL.middleware.xsd.Base64Binary;


/**
 * Ontological representation of KeyRing in the cryptographic ontology. 
 * Methods included in this class are the mandatory ones for representing an
 * ontological concept in Java classes for the universAAL platform. In addition
 * getters and setters for properties are included.
 * 
 * @author 
 * @author Generated by the OntologyUML2Java transformation of AAL Studio
 */
public class KeyRing extends EncryptionKey {
  public static final String MY_URI = CryptographicOntology.NAMESPACE
    + "KeyRing";
  public static final String PROP_PRIVATE_KEY = CryptographicOntology.NAMESPACE
    + "privateKey";
  public static final String PROP_CERTIFICATION_AUTHORITY = CryptographicOntology.NAMESPACE
    + "certificationAuthority";
  public static final String PROP_PUBLIC_KEY = CryptographicOntology.NAMESPACE
    + "publicKey";

  public static final String PROP_ASYMMETRIC = CryptographicOntology.NAMESPACE
		    + "usedWithAsymetricMethod";

  public KeyRing () {
    super();
  }
  
  public KeyRing (String uri) {
    super(uri);
  }

  public String getClassURI() {
    return MY_URI;
  }
  
  public int getPropSerializationType(String propURI) {
    if (PROP_PRIVATE_KEY.equals(propURI))
      return PROP_SERIALIZATION_FULL;
    if (PROP_CERTIFICATION_AUTHORITY.equals(propURI))
      return PROP_SERIALIZATION_FULL;
    if (PROP_PUBLIC_KEY.equals(propURI))
      return PROP_SERIALIZATION_FULL;
    return super.getPropSerializationType(propURI);
  } 

  public boolean isWellFormed() {
	return super.isWellFormed() 
      && hasProperty(PROP_PRIVATE_KEY)
      && hasProperty(PROP_CERTIFICATION_AUTHORITY)
      && hasProperty(PROP_PUBLIC_KEY);
  }

  public Base64Binary getPublicKey() {
    return (Base64Binary)getProperty(PROP_PUBLIC_KEY);
  }		

  public void setPublicKey(Base64Binary newPropValue) {
      changeProperty(PROP_PUBLIC_KEY, newPropValue);
  }		

  public Base64Binary getPrivateKey() {
    return (Base64Binary)getProperty(PROP_PRIVATE_KEY);
  }		

  public void setPrivateKey(Base64Binary newPropValue) {
      changeProperty(PROP_PRIVATE_KEY, newPropValue);
  }		

  public CertificationAuthority[] getCertificationAuthority() {
    Object propList = getProperty(PROP_CERTIFICATION_AUTHORITY);
    if (propList instanceof List)
      return (CertificationAuthority[]) ((List) propList).toArray(new CertificationAuthority[0]);
    else if (propList != null)
      return new CertificationAuthority[] {(CertificationAuthority)propList}; // Handle special case of a single item not contained in a list
    return new CertificationAuthority[0];
  }

  public void addCertificationAuthority(CertificationAuthority newValue) {
    Object propList = getProperty(PROP_CERTIFICATION_AUTHORITY);
    List newList;
    if (propList instanceof List)
      newList = (List)propList;
    else {
      newList = new ArrayList();
      if (propList != null)
        newList.add(propList); // Handle special case of a single previous item not contained in a list
    }
    newList.add(newValue);
    changeProperty(PROP_CERTIFICATION_AUTHORITY, newList);
  }
  

  public void setCertificationAuthority(CertificationAuthority[] propertyValue) {
    List propList = new ArrayList(propertyValue.length);
    for (int i = 0; i < propertyValue.length; i++) {
      propList.add(propertyValue[i]);
    }
    changeProperty(PROP_CERTIFICATION_AUTHORITY, propList);
  }
  
  public AsymmetricEncryption getAsymmetric(){
	  return (AsymmetricEncryption) getProperty(PROP_ASYMMETRIC);
  }
  
  public void setAsymmetric(AsymmetricEncryption ae){
	  changeProperty(PROP_ASYMMETRIC, ae);
  }

}
