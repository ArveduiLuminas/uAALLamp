/*
	Copyright 2015 ITACA-SABIEN, http://www.tsb.upv.es
	Instituto Tecnologico de Aplicaciones de Comunicacion 
	Avanzadas - Grupo Tecnologias para la Salud y el 
	Bienestar (SABIEN)
	
	See the NOTICE file distributed with this work for additional 
	information regarding copyright ownership
	
	Licensed under the Apache License, Version 2.0 (the "License");
	you may not use this file except in compliance with the License.
	You may obtain a copy of the License at
	
	  http://www.apache.org/licenses/LICENSE-2.0
	
	Unless required by applicable law or agreed to in writing, software
	distributed under the License is distributed on an "AS IS" BASIS,
	WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
	See the License for the specific language governing permissions and
	limitations under the License.
 */
package org.universAAL.ontology.personalhealthdevice;

import org.universAAL.ontology.device.Sensor;
import org.universAAL.ontology.healthmeasurement.owl.HeartRate;

public class HeartRateSensor extends Sensor {
    public static final String MY_URI = PersonalHealthDeviceOntology.NAMESPACE
	    + "HeartRateSensor";

    public HeartRateSensor() {
	super();
    }

    public HeartRateSensor(String uri) {
	super(uri);
    }

    public String getClassURI() {
	return MY_URI;
    }

    public void setValue(HeartRate hr) {
	setProperty(PROP_HAS_VALUE, hr);
    }

    public HeartRate getValue() {
	return (HeartRate) getProperty(PROP_HAS_VALUE);
    }

    public int getPropSerializationType(String propURI) {
	return PROP_SERIALIZATION_FULL;
    }
}
