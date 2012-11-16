import java.util.Scanner;

//Name: Tyler Holland
//Language: Java
public class Lab0
{
	public static void main(String[] args)
	{
		File team = null;
		File player = null;
		Scanner teamscan = null;
		Scanner playerscan = null;
		
		team = new File(team.txt);
		player = new File(player.txt);
		teamscan = new Scanner(team);
		playerscan = new Scanner(player);
		
		int total = null;
		int east = null;
		int west = null;
		
		teamscan.delimiter(",");
		playerscan.delimiter(",");
		
		String team1 = null;
		String team2 = null;
		String conf1 = null;
		String conf2 = null;
		
		
		if (teamscan.hasNext())
		{
			team1 = teamscan.next();
		}
		if (teamscan.hasNext())
		{
			conf1 = teamscan.next();
		}
		if (teamscan.hasNext())
		{
			teamscan.next();
		}
		if (teamscan.hasNext())
		{
			team2 = teamscan.next();
		}
		if (teamscan.hasNext())
		{
			conf2 = teamscan.next();
		}
		if (teamscan.hasNext())
		{
			teamscan.next();
		}
		System.out.println(team1);
	}
}
