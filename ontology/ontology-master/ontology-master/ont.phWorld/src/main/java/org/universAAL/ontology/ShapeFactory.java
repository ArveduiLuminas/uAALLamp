/*
	Copyright 2008-20144 Fraunhofer IGD, http://www.igd.fraunhofer.de
	Fraunhofer-Gesellschaft - Institute for Computer Graphics Research
	
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
package org.universAAL.ontology;

import org.universAAL.middleware.rdf.Resource;
import org.universAAL.middleware.rdf.ResourceFactory;
import org.universAAL.ontology.shape.Box;
import org.universAAL.ontology.shape.Circle;
import org.universAAL.ontology.shape.ConeSegment;
import org.universAAL.ontology.shape.Ellipse;
import org.universAAL.ontology.shape.Line;
import org.universAAL.ontology.shape.LineSegment;
import org.universAAL.ontology.shape.MergedShape;
import org.universAAL.ontology.shape.Polygon;
import org.universAAL.ontology.shape.Polyhedron;
import org.universAAL.ontology.shape.QuasiCylinder;
import org.universAAL.ontology.shape.Sphere;
import org.universAAL.ontology.shape.Triangle;

public class ShapeFactory implements ResourceFactory {

    public Resource createInstance(String classURI, String instanceURI,
	    int factoryIndex) {

	switch (factoryIndex) {
	case 0:
	    return new Box(instanceURI);
	case 1:
	    return new Ellipse(instanceURI);
	case 2:
	    return new Circle(instanceURI);
	case 3:
	    return new Line(instanceURI);
	case 4:
	    return new LineSegment(instanceURI);
	case 5:
	    return new ConeSegment(instanceURI);
	case 6:
	    return new Polygon(instanceURI);
	case 7:
	    return new Triangle(instanceURI);
	case 8:
	    return new Sphere(instanceURI);
	case 9:
	    return new QuasiCylinder(instanceURI);
	case 10:
	    return new Polyhedron(instanceURI);
	case 11:
	    return new MergedShape(instanceURI);
	}

	return null;
    }
}
