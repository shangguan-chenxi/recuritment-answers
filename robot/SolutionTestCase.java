import java.util.Scanner; 
import java.lang.String;
import java.util.regex.*;

public class SolutionTestCase{
    public static void main(String[] args) {
        Robot R = new Robot();
        Scanner sc = new Scanner(System.in);
        boolean isRobotPlacedCorrectly = false;
        int cmdCount = 0; // for auto test example
        String cmd = "";  // command to be executed
        System.out.println("Input: PLACE X,Y,F / MOVE / LEFT / RIGHT / REPORT / EXIT");
        while(true){
            /*
             * manual input commands
             * disable auto test when enable manual input
             */
            //cmd = sc.nextLine().toUpperCase();
            
            /* DEVELOPMENT TEST */
            //System.out.println(cmd);
            //R.place(0,0,"SOUTH");
            //R.move();
            //R.report();
            
            /*
             * examples of commands 
             * disable manual inpout when enable auto test
             */
            //String[] cmds = {"place 0,0,north", "move", "report"};
            //String[] cmds = {"place 0,0,north", "left", "report"};
            //String[] cmds = {"place 1,2,east", "move", "move", "left", "move", "report"};
            String[] cmds = {"move", "place 5,5,north", "left", "move", "place 1,2,east", "move", "move", "right", "move", "report"};
            if (cmdCount < cmds.length){
                cmd = cmds[cmdCount].toUpperCase();
                System.out.println(cmd);
                cmdCount++;
            }else{
                break;
            }
            
            if (Pattern.matches("EXIT", cmd)){
                break;
            }
            
            if (Pattern.matches("PLACE.*", cmd)){
                //System.out.println("place robot");
                String[] c = cmd.split(",| ");
                //System.out.println(c[0] + c[1] + c[2] + c[3]);
                isRobotPlacedCorrectly = R.place(Integer.valueOf(c[1]), Integer.valueOf(c[2]), c[3]);
                //R.report();
            }
            
            if(isRobotPlacedCorrectly){
                if (Pattern.matches("LEFT", cmd)){
                    R.turnLeft();
                    //R.report();
                }
                
                if (Pattern.matches("RIGHT", cmd)){
                    R.turnRight();
                    //R.report();
                }
                
                if (Pattern.matches("MOVE", cmd)){
                    R.move();
                    //R.report();
                }
                
                if (Pattern.matches("REPORT", cmd)){
                    R.report();
                }
            }
        }
        sc.close();
    }
}