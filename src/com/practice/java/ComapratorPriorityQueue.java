package com.practice.java;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class ComapratorPriorityQueue {
	public static class Marks {
		int total;
		int index;

		public Marks(int total, int index) {
			this.total = total;
			this.index = index;
		}

		public int getTotal() {
			return total;
		}

		public void setTotal(int total) {
			this.total = total;
		}

		public int getIndex() {
			return index;
		}

		public void setIndex(int index) {
			this.index = index;
		}
	}

	public static int rankIndex(List<List<Integer>> values, int rank) {
		PriorityQueue<Marks> marksPriorityQueue = new PriorityQueue<>(new Comparator<Marks>() {
			@Override
			public int compare(Marks o1, Marks o2) {
				if (o1.getTotal() < o2.getTotal()) {
					return 1;
				}
				if (o1.getTotal() > o2.getTotal()) {
					return -1;
				}

				if (o1.getIndex() < o2.getIndex()) {
					return -1;
				}

				if (o1.getIndex() > o2.getIndex()) {
					return 1;
				}

				return 0;
			}
		});

		int ind = 0;
		for (List<Integer> value : values) {
			int sum = 0;
			for (Integer val : value) {
				sum += val;
			}
			marksPriorityQueue.add(new Marks(sum, ind++));
		}

		while (rank > 1) {
			marksPriorityQueue.poll();
			rank--;
		}
		return marksPriorityQueue.poll().getIndex();
	}
}
