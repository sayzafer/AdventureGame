public abstract class NormalLoc extends Locations{

    public NormalLoc(Player player, String name){
        super(player, name);
    }

    @Override
    public boolean onLocation() {
        return true;
    }


}
