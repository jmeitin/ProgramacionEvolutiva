package Chromosomes;

import java.util.Random;

public class ChromosomeP3 extends Chromosome<Integer, Integer> {
	//protected int[] genes;

	private int min_depth = 2;
	private int max_depth = 5;
	Random rand = new Random();
	private BinaryTree tree;
	private String fenotype;
	private String creation_type = "";
	
	public ChromosomeP3(double tolerance, String t) {
		super(10); // ????????????????
		
		//calculate random depth for tree
		int depth = (int)(min_depth + (rand.nextDouble() * (max_depth - min_depth)));
		//create tree
		tree = new BinaryTree(true); //is root
		
		//Init tree
		creation_type = t;
		
		switch(creation_type){
		case "Full": 
			tree.FullInitalization(depth);
		break;
		case "Grow":
			tree.GrowInitalization(depth);
		break;
		default:
			tree.FullInitalization(depth);
		break;
		}
		
		initGenes();
		calculateFenotypes();
	}

	@Override
	protected void initGenes() {
		
		
	}
	
	@Override
	public void calculateFenotypes() {
		
	}
	
	

	@Override
	public double evaluate() {
		
		
		return brute_fitness;
	}

	@Override
	protected Chromosome getNewInstance() {
		return new ChromosomeP2(this.tolerance);
	}

	@Override
	protected boolean mutateGene(int pos, Random rand, double mutation_chance) {
		// TODO Auto-generated method stub
		return false;
	}

	
	// Returns a copy of this Chromosome
	@Override
	public Chromosome getCopy()
	{
		ChromosomeP2 chromosome = (ChromosomeP2) getNewInstance();
		chromosome.setFitness(this.fitness);	
		chromosome.setBruteFitness(this.brute_fitness);
		chromosome.setScore(this.score);
		chromosome.setAccumulatedScore(this.scoreAccumulated);
		chromosome.fenotypes = this.fenotypes;
		chromosome.num_of_genes = this.num_of_genes;
		//chromosome.genes = this.getGenesCopy();
		
		return chromosome;
	};
}
