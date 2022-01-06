import java.util.Scanner;

public class Game {
    private Scanner input = new Scanner(System.in);


    public void start(){
        System.out.println("Macera oyununa hoşgeldiniz !");
        System.out.println("Lütfen bir isim giriniz. ");
        //String playerName = input.nextLine();
        Player player = new Player("Tezz");
        System.out.println("Tezz bu karanlık ve sisli adaya hoşgeldin! " );
        System.out.println("Oyuna başlamak için karakterinizi id numarasına göre seçiniz!");
        player.selectWarrior();

        while (true){
                player.printInfo();
                Locations location = null;
                System.out.println();
                System.out.println("--------------------Bölgeler--------------------");
                System.out.println();
                System.out.println("1- Güvenli Ev");
                System.out.println("2- Mağaza");
                System.out.println("3- Mağaraya git, Ödül => Yemek");
                System.out.println("4- Ormana git, Ödül => Odun");
                System.out.println("5- Nehire git, Ödül => Su");
                System.out.println("0- Çıkış yap");
                System.out.println("Lütfen gitmek istediğiniz bölgeyi seçiniz");
                int selectLoc = input.nextInt();
                switch (selectLoc){
                    case 0:
                        location = null;
                        break;
                    case 1:
                        location = new SafeHouse(player);
                        break;
                    case 2:
                        location = new ToolStore(player);
                        break;
                    case 3:
                        location = new Cave(player);
                        break;
                    case 4:
                        location = new Forest(player);
                        break;
                    case 5:
                        location = new River(player);
                        break;
                    default:
                        location = new SafeHouse(player);

                }
                if(location == null){
                    System.out.println("Oyundan çıkış yaptınız");
                    break;
                }
                if(!location.onLocation()){
                    System.out.println("Game Over!");
                    break;
                }
        }
    }
}
