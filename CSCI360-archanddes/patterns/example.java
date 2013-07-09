public interface Barracks
{
	public static needTroops createTroop(input type);
	{
	neededtroop Troop = whichTroop(type)

		switch (Troop)
		{
		
			case Mage:
				return new MakeMage(type);
			case Warrior:
				return new MakeWarrior(type);
			case Archer:
				return new MakeArcher(type);
				
		}	
	}
}	
	
	
public class MakeWarrior implements Barracks
{
	public needTroops createTroop()
	{
		//code here...
		return troop
	}
}

public class MakeArcher implements Barracks
{
	public needTroops createTroop()
	{
		//code here...
		return troop
	}
}

public class MakeMage implements Barracks
{
	public needTroops createTroop()
	{
		//code here...
		return troop
	}
}
