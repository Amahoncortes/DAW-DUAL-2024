public class Main {
    public static void main(String[] args) {

    }

    public static int getDamage (int speed, int armor, int distance){
        int baseDamage = distance < 3 || (distance < 20 && speed > 500) ? speed / 10 : (speed / 10) - armor;
        int additionalDamage = distance < 3 || (distance < 20 && speed > 500) || (distance > 20 && speed > 500) ? 0 : (distance / 10);

        return Math.max(baseDamage - additionalDamage, 0);
    }

    public static boolean isDeadByBodyShot (int life, int damage){
        return life - damage <= 0;
    }

    public static int getNumObjects (boolean[][] map){
        int cont = 0;
        for (int i = 0; i < map.length; i++){
            for (int j = 0; j < map[0].length; j++)
                cont += map[i][j] ? 1 : 0;
        }
        return cont;
    }

    public static boolean isHit (boolean [][] screen, int y, int x){
        return screen[y][x];
    }

    public static boolean isHeadShot (boolean [][] screen, int y, int x){
        if (screen[y][x - 1] && screen[y][x + 1]){
            for ( int i = y; i < y + 4; i++){
                if (!screen[i][x])
                    return false;
            }
        }else
            return false;
        return true;
    }

    public static int[] getEnemyPosition (boolean[][] screen){

        for (int i = 0; i < screen.length; i++){
            for (int j = 0; j < screen[0].length; j++){
                if(screen[i][j]){
                    return new int[]{i + 2, j + 1};
                }
            }
        }
        return new int[]{0, 0};
    }

}
