package toi_uu_lap_ke_hoach;

import com.google.ortools.linearsolver.MPConstraint;
import com.google.ortools.linearsolver.MPObjective;
import com.google.ortools.linearsolver.MPSolver;
import com.google.ortools.linearsolver.MPVariable;

public class Mix_Integer_program {
	static {
		System.loadLibrary("jniortools");
	}
	
	public static void  main (String[] args) {
		double INF = java.lang.Double.POSITIVE_INFINITY;
		MPSolver solver = new MPSolver("SImpleMIP", MPSolver.OptimizationProblemType.CBC_MIXED_INTEGER_PROGRAMMING );
		MPVariable x1 = solver.makeNumVar(0, 14, "x1");
		MPVariable x2 = solver.makeIntVar(0, 20, "x2");
		
		MPConstraint c1 = solver.makeConstraint(-INF, 7);
		c1.setCoefficient(x1, 1);
		c1.setCoefficient(x2, -10);
		
		
		MPConstraint c2 = solver.makeConstraint(0, 20);
		c2.setCoefficient(x1, 2);
		c2.setCoefficient(x2, 3);
		
		MPObjective obj = solver.objective();
		obj.setCoefficient(x1, 1);
		obj.setCoefficient(x2, 1);
		obj.setMaximization();
		
		
		MPSolver.ResultStatus rs = solver.solve();
		if(rs != MPSolver.ResultStatus.OPTIMAL) {
			System.out.println("Cannot find optimal solution");
		}
		else {
			System.out.println("Objective value = " + obj.value());
			System.out.println("x1 = " + x1.solutionValue());
			System.out.println("x2 = " + x2.solutionValue());
		}
		
		
	}
}
