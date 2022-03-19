package ships;
/*
 * @author Tanay Parikh 
 */
import projectiles.Projectile;
import utils.Position;

public class MultiShooterShip extends ShooterShip {
	public static final int NUM_CANNONS = 5;
	public static final double SPREAD = 0.25;
	private Position p;

  /**
   * Constructs a MultiShooterShip
   * @param p The initial position
   * @param armor The initial armor level
   */
	public MultiShooterShip(Position p, int armor) 
	{
		super(p,armor);
		this.p = p;
	}

  /**
   * Fires NUM_CANNONS projectiles, that spread out as they fall
   * @return An array of projectiles
   */
	@Override
	public Projectile[] fire() {
		Projectile[] multi = new Projectile[NUM_CANNONS];
		for(int i=0; i < multi.length; i++)
		{
			double x = i - (NUM_CANNONS / 2) * SPREAD;
			Projectile temp = new Projectile(p, x, (-1) * PROJECTILE_SPEED, 0);
			multi[i] = temp; 
		}
          /*
           * Hint, to get a spread, second parameter to Projectile() should
           * be something like (i - (NUM_CANNONS / 2)) * SPREAD
           */
         return multi;
	}

	@Override
	public String imgPath() {
		return "res/monster3.png";
	}
}
