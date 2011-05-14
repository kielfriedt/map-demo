package com.map.demo;

import java.awt.Color;

public class MAPFrame {
	private static float MAXVAL = 4000000;
	private final int[] vals;
	private final boolean[] hits;
	private final int level;

	MAPFrame(int[] vals, boolean[] hits, int level) {
		this.vals = vals;
		this.hits = hits;
		this.level = level;
	}

	public int[] getVals() {
		return vals;
	}

	public boolean[] getHits() {
		return hits;
	}

	public int getLevel() {
		return level;
	}

	public Color getColor(int offset, int packTo) {
		int count = vals.length / packTo;
		float total = 0;
		for (int i = offset; i < offset + count; i++) {
			total += Math.abs(vals[offset]);
		}
		float percent = (total / count) / MAXVAL;
		if (percent > 1) {
			percent = 1;
		}
		return new Color((1 - percent), (1 - percent), (1 - percent));
	}
}
