package com.capgemini.assignment5.SortingPlayers;
//
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class FileUtility{
	List<Players> readFileData(BufferedReader obj) {
		List<Players> playersList=new ArrayList<Players>();
		String temp;
		try {
		while ((temp = obj.readLine()) != null) {
			String dataArray[]=temp.split(",");
            playersList.add(new Players(Integer.valueOf(dataArray[0]), Integer.valueOf(dataArray[4]), dataArray[1], dataArray[2], dataArray[3]));
		}
		}
		catch(IOException e) {
			System.out.println(e);
		}
		return playersList;
    }
	
	void writeDataToFile(List<Players> playerList) {
        boolean swapped;
        for (int i = 0; i < playerList.size() - 1; i++)
        {
            swapped = false;
            for (int j = 0; j < playerList.size() - i - 1; j++)
            {
                if (playerList.get(j).getCapNumber() > playerList.get(j+1).getCapNumber())
                {
                    // swap elements
                    Players tempPlayers=new Players(playerList.get(j).getCapNumber(), playerList.get(j).getMatchesPlayed(), playerList.get(j).getPlayerName(), playerList.get(j).getSkill(), playerList.get(j).getCountry());
                    playerList.set(j, playerList.get(j+1));
                    playerList.set(j+1, tempPlayers);
                    swapped = true;
                }
            }
 
            // IF no two elements were
            // swapped by inner loop, then break
            if (swapped == false)
                break;
        }
        try {
        FileWriter fileObj=new FileWriter(".\\src\\main\\java\\com\\capgemini\\assignment5\\SortingPlayersOutput.csv");
        for(Players i:playerList) {
        String temp=String.valueOf(i.getCapNumber())+","+i.getPlayerName()+","+i.getSkill()+","+i.getCountry()+","+String.valueOf(i.getMatchesPlayed());
        fileObj.append(temp);
        fileObj.append('\n');
        }
        fileObj.close();
        }
        catch(IOException e) {
        	System.out.println(e);
        }
        
    }
}
