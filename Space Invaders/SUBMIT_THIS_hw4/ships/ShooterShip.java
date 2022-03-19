package ships;
/*
 * @author Tanay Parikh 
 */
import projectiles.Bomb;
import projectiles.Projectile;
import utils.Position;

public class ShooterShip extends InvaderShip {
	
	private Position p;
  /**
   * Constructs a ShooterShip
   * @param p The initial position
   * @param armor The initial armor level
   */
	public ShooterShip(Position p, int armor)
	{
		super(p,armor);
		this.p = p;
	}

	public Projectile[] fire()
	{
		Projectile[] shooter = new Projectile[1];
		shooter[0] = new Projectile(p, 0, (-1) * PROJECTILE_SPEED, 0);
		return shooter;
	}

	@Override
	public String imgPath() {
		return "res/monster.png";

	}

	@Override
	public int getPoints() {
		return 50;
	}
}
