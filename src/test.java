public class test {
    /*boolean mystique(int x, int y) {
        int[] arr = new int[y];
        boolean z = false;
        int i = 1;
        while(!z) {
            if(i == y)
                return true;
            int number = (int) Math.pow(x, i);
            if(arr[number%y] != 0) {
                z = true;
            }
            else {
                arr[number%y] = 1;
            }
            i++;
        }
        return false;
    }*/
    int mystique(int n) {
        int i = 1;
        while(i*i<=n) {
            i++;
        }
        System.out.println(i);
        return i;
    }
}
