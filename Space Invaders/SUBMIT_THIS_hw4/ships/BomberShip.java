package ships;
/*
 * @author Tanay Parikh 
 */
import projectiles.Bomb;
import projectiles.Projectile;
import utils.Position;

public class BomberShip extends InvaderShip {
	public static final double EXPLOSION_RADIUS = 10;
	private Position p;
  /**
   * Constructs a BomberShip
   * @param p The initial position
   * @param armor The initial armor level
   */
	public BomberShip(Position p, int armor)
	{
		super(p,armor);
		this.p = p;
	}

  /**
   * Drops a single bomb
   * @return An array containing a single bomb
   */
	public Projectile[] fire() 
	{
		Bomb[] bomber = new Bomb[1];
		bomber[0] = new Bomb(p, 0, (-1) * PROJECTILE_SPEED, 0, EXPLOSION_RADIUS);
		return bomber;
	}

	@Override
	public String imgPath() {
		return "res/monster2.png";
	}

	@Override
	public int getPoints() {
		return 100;
	}
}
