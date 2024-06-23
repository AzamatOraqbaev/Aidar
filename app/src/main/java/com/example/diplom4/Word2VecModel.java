package com.example.diplom4;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.*;

public class Word2VecModel {

    private Map<String, double[]> wordVectors = new HashMap<>();

    public void loadModel(BufferedReader reader) throws IOException {
        String line;
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(" ");
            String word = parts[0];
            double[] vector = new double[parts.length - 1];
            for (int i = 1; i < parts.length; i++) {
                vector[i - 1] = Double.parseDouble(parts[i]);
            }
            wordVectors.put(word, vector);
        }
    }

    public double[] getVector(String word) {
        return wordVectors.get(word);
    }

    public boolean containsWord(String word) {
        return wordVectors.containsKey(word);
    }

    public List<String> getNearestWords(String word, int topN) {
        double[] targetVector = getVector(word);
        if (targetVector == null) {
            return Collections.emptyList();
        }

        PriorityQueue<Map.Entry<String, Double>> pq = new PriorityQueue<>(
                Map.Entry.comparingByValue()
        );

        for (Map.Entry<String, double[]> entry : wordVectors.entrySet()) {
            if (entry.getKey().equals(word)) continue;
            double similarity = cosineSimilarity(targetVector, entry.getValue());
            pq.offer(new AbstractMap.SimpleEntry<>(entry.getKey(), similarity));
            if (pq.size() > topN) {
                pq.poll();
            }
        }

        List<String> nearestWords = new ArrayList<>();
        while (!pq.isEmpty()) {
            nearestWords.add(pq.poll().getKey());
        }
        Collections.reverse(nearestWords);
        return nearestWords;
    }

    private double cosineSimilarity(double[] vectorA, double[] vectorB) {
        double dotProduct = 0.0;
        double normA = 0.0;
        double normB = 0.0;
        for (int i = 0; i < vectorA.length; i++) {
            dotProduct += vectorA[i] * vectorB[i];
            normA += Math.pow(vectorA[i], 2);
            normB += Math.pow(vectorB[i], 2);
        }
        return dotProduct / (Math.sqrt(normA) * Math.sqrt(normB));
    }

    public Set<String> getVocabulary() {
        return wordVectors.keySet();
    }
}
