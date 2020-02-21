package competition;

import game.Game;
import player.GameLoader;

/**
 * Some utility methods for the Ludii AI Competition planned
 * for IEEE CoG 2020 (http://ieee-cog.org/2020/competitions_conference)
 *
 * @author Dennis Soemers
 */
public class IeeeCog2020
{
	
	/**
	 * The Ludii AI Competition at IEEE CoG 2020 will only use
	 * games that:
	 * 	- Have two players
	 * 	- Are zero-sum
	 * 	- Are adversarial
	 * 	- Are turn-based
	 * 	- Are sequential
	 * 	- Are deterministic
	 * 	- Are fully observable
	 * 
	 * @param game
	 * @return True if the given game could be valid for use in
	 * the Ludii AI Competition at IEEE CoG 2020.
	 */
	public static boolean isGameValid(final Game game)
	{
		if (game.players().count() != 2)
			return false;	// Only 2-player games
		
		// NOTE: we currently do not have a check to verify that
		// games are zero-sum / adversarial here.
		
		if (!game.isAlternatingMoveGame())
			return false;	// Only turn-base / sequential
		
		if (game.isStochasticGame())
			return false;	// Only deterministic
		
		if (game.hiddenInformation())
			return false;	// Only fully observable games
		
		return true;
	}
	
	/**
	 * This main method will look through all the .lud files packaged in
	 * the Ludii.jar file, and list all the games that could be valid
	 * for use in the Ludii AI Competition at IEEE CoG 2020.
	 * 
	 * @param args
	 */
	public static void main(final String[] args)
	{
		final String[] allPaths = GameLoader.listGames();
		
		System.out.println("Warning: the following code is known to include one false positive");
		System.out.println("in the generated list: War (a card game). This will be corrected with");
		System.out.println("the release of Ludii version 1.0.0.");
		System.out.println();
		System.out.println("Valid games in Ludii.jar for the Ludii AI Competition at IEEE CoG 2020:");
		for (final String path : allPaths)
		{
			final Game game = GameLoader.loadGameFromName(path);
			game.create(0);
			
			if (isGameValid(game))
				System.out.println(path);
		}
	}

}
