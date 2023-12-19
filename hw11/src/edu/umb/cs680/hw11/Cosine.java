package edu.umb.cs680.hw11;

import java.util.List;

public class Cosine implements DistanceMetric{
	public double distance(List<Double> p1, List<Double> p2) {
		return dot(p1, p2)/ (norm(p1) * norm(p2));		
	}

    public double dot(List<Double> p1, List<Double> p2) {
        double sum = 0.0;
        for(int i=0; i < p1.size(); i++) {
			sum += (p1.get(i) * p2.get(i));
		}
        return sum;
    }

    public double norm(List<Double> p) {
        double sumOfSquared = 0.0;
		for(int i=0; i < p.size(); i++) {
			sumOfSquared += Math.pow(p.get(i), 2);
		}
		return Math.sqrt(sumOfSquared);	
    }
}