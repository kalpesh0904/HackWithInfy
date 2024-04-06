package Sample_Qs;
import java.util.*;

public class GymWorkout {

    public static int minExercises(int energy, int numExercises, int[] exerciseCosts) {
        // Sort exercises by energy cost (ascending)
        Arrays.sort(exerciseCosts);

        // Check if any single exercise drains all energy
        for (int cost : exerciseCosts) {
            if (cost == energy) {
                return 1; // One exercise drains all energy
            }
        }

        int exercisesDone = 0;
        for (int i = 0; i < numExercises; i++) {
            int cost = exerciseCosts[i];
            if (energy <= 0) {
                return -1; // Already tired
            }
            if (cost > energy) {
                continue; // Skip too expensive exercises
            }
            energy -= cost;
            exercisesDone++;
            // Check if exercise can be done again (max twice)
            if (exercisesDone % 2 == 0) {
                continue;
            }
            energy -= cost; // Do the exercise again if allowed
            exercisesDone++;
        }

        // If loop finishes without reaching 0 energy, return -1
        return energy > 0 ? -1 : exercisesDone;
    }

    public static void main(String[] args) {
        int energy = 2;
        int numExercises = 3;
        int[] exerciseCosts = {1, 5, 2};

        int minExercises = minExercises(energy, numExercises, exerciseCosts);
        if (minExercises == -1) {
            System.out.println("You won't get tired with these exercises.");
        } else {
            System.out.println("Minimum exercises needed: " + minExercises);
        }
    }
}


