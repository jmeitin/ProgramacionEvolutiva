package GeneticAlgorithm;

import CrossAlgorithms.CrossAlgorithm;
import MutationAlgorithm.MutationAlgorithm;
import SelectionAlgorithms.SelectionAlgorithm;

public class GeneticAlgorithmData {
	public int poblation_size;
	public int max_gen_num;
	public double cross_chance;
	public double mutation_chance;
	public double tolerance;
	public double elitism_percentage;
	public boolean maximize;
	public int dimensions;
	public ChromosomeFactory chromosome_factory;
	public SelectionAlgorithm selectionAlgorithm;
	public CrossAlgorithm crossAlgorithm;
	public MutationAlgorithm mutationAlgorithm;
}
