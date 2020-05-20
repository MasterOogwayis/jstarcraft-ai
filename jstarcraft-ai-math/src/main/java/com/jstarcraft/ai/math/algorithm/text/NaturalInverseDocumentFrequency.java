package com.jstarcraft.ai.math.algorithm.text;

import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.math3.util.FastMath;

import it.unimi.dsi.fastutil.ints.Int2FloatMap;
import it.unimi.dsi.fastutil.ints.IntIterator;

/**
 * Inverse Document Frequency
 * 
 * <pre>
 * inverse document frequency
 * </pre>
 * 
 * @author Birdy
 *
 */
public class NaturalInverseDocumentFrequency extends AbstractInverseDocumentFrequency {

	public NaturalInverseDocumentFrequency(Int2FloatMap keyValues, TermFrequency... documents) {
		super(keyValues);
		int size = documents.length;
		for (TermFrequency document : documents) {
			IntIterator iterator = document.getKeys().iterator();
			while (iterator.hasNext()) {
				int term = iterator.nextInt();
				keyValues.put(term, keyValues.getOrDefault(term, 0F) + 1F);
			}
		}
		for (Int2FloatMap.Entry term : keyValues.int2FloatEntrySet()) {
			int key = term.getIntKey();
			float value = term.getFloatValue();
			keyValues.put(key, (float) FastMath.log(size / value));
		}
	}

	public NaturalInverseDocumentFrequency(Int2FloatMap keyValues, Collection<TermFrequency> documents) {
		super(keyValues);
		int size = documents.size();
		for (TermFrequency document : documents) {
			IntIterator iterator = document.getKeys().iterator();
			while (iterator.hasNext()) {
				int term = iterator.nextInt();
				keyValues.put(term, keyValues.getOrDefault(term, 0F) + 1F);
			}
		}
		for (Int2FloatMap.Entry term : keyValues.int2FloatEntrySet()) {
			int key = term.getIntKey();
			float value = term.getFloatValue();
			keyValues.put(key, (float) FastMath.log(size / value));
		}
	}

	public NaturalInverseDocumentFrequency(Int2FloatMap keyValues, Iterator<TermFrequency> documents) {
		super(keyValues);
		int size = 0;
		while (documents.hasNext()) {
			size++;
			TermFrequency document = documents.next();
			IntIterator iterator = document.getKeys().iterator();
			while (iterator.hasNext()) {
				int term = iterator.nextInt();
				keyValues.put(term, keyValues.getOrDefault(term, 0F) + 1F);
			}
		}
		for (Int2FloatMap.Entry term : keyValues.int2FloatEntrySet()) {
			int key = term.getIntKey();
			float value = term.getFloatValue();
			keyValues.put(key, (float) FastMath.log(size / value));
		}
	}

}
