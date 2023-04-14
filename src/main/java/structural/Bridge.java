package structural;

interface RemoteCtrlInterface{
    public boolean powerOn();
    public void nextChannel();
    public void previousChannel();
    public void volumeUp();
    public void volumeDown();
}

class RemoteCtrl implements RemoteCtrlInterface{
    public boolean power;
    @Override
    public boolean powerOn() {
        if(power){
            System.out.println("Power Off");
            power = false;
            return !power;
        }else{
            System.out.println("Power On");
            power = true;
            return !power;
        }
    }

    @Override
    public void nextChannel() {
        System.out.println("Next Channel");
    }

    @Override
    public void previousChannel() {
        System.out.println("Previous Channel");
    }

    @Override
    public void volumeUp() {
        System.out.println("Volume Up");
    }

    @Override
    public void volumeDown() {
        System.out.println("Volume Down");
    }
}

class Television{
    private RemoteCtrlInterface remote;

    public void setRemote(RemoteCtrlInterface remote){
        this.remote = remote;
    }

    public void actions(String signal){
        switch (signal) {
            case "on" -> this.remote.powerOn();
            case "next" -> this.remote.nextChannel();
            case "previous" -> this.remote.previousChannel();
            case "volumeUp" -> this.remote.volumeUp();
            case "volumeDown" -> this.remote.volumeDown();
        }
    }
}

public class Bridge {
    public static void main(String[] args) {
        Television tv = new Television();
        tv.setRemote(new RemoteCtrl());

        tv.actions("volumeDown");
        tv.actions("volumeUp");
        tv.actions("on");
        tv.actions("next");
    }
}
