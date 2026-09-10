import java.util.ArrayList;

enum Connection {
    WIFI, BLUETOOTH
}

interface switchable {
    public void Switch();
}

interface connectable {
    public String connect();
}

interface lockable {
    public void lock();
}


abstract class smartHome {
    private String id;
    private String name;
    private double daya;

    public smartHome (String id,String name,double daya) {
        this.id = id;
        this.name = name;
        this.daya = daya;
    }

    public String getid (String id) {
        return id;
    }
    public String getname (String name) {
        return name;
    }
    public double daya (double daya) {
        return daya;
    }

   public abstract String status ();

   public String printData() {
        return  "[" + name  + "] ( ID : " + id  + ") - Daya : " + daya + "W";
    }
}

class smartTV extends smartHome implements connectable,switchable {
    protected int Volume;
    protected int Channel;
    protected String switchStatus;
    

    public smartTV (String id, String name, double daya, int Channel, int Volume, String switchStatus) {
        super (id,name,daya);
        this.Channel = Channel;
        this.Volume = Volume;
        this.switchStatus = switchStatus;
    }

    @Override
    public String status () { 
        return "Status : " + switchStatus;
    }

    @Override 
    public String connect () { 
        return "Koneksi : " + Connection.WIFI;
    }

    @Override 
    public void Switch () { 
        switchStatus = "Mati";
    }


    @Override
    public String printData() {
        return "Smart TV " + super.printData() + " | Status : " + status() + " | Koneksi " + connect() + " | Channel : " + Channel + " | Volume : " + Volume;
    }
}

class smartSpeaker extends smartHome implements connectable,switchable {
    protected int Volume;
    protected String switchStatus;
    

    public smartSpeaker (String id, String name, double daya, int Volume, String switchStatus) {
        super (id,name,daya);
        this.Volume = Volume;
        this.switchStatus = switchStatus;
    }

    @Override
    public String status () { 
        return "Status : " + switchStatus;
    }

    @Override 
    public String connect () { 
        return "Koneksi : " + Connection.BLUETOOTH;
    }

    @Override 
    public void Switch () { 
        switchStatus = "Menyala";
    }

    @Override
    public String printData() {
        return "Smart Speaker " + super.printData() + " | Status : " + status() + " | Koneksi " + connect() + " | Volume : " + Volume;
    }
}

class smartDoorLock extends smartHome implements lockable {
    protected String pin;
    protected String lockstatus;

    public smartDoorLock (String id, String name, double daya,String lockstatus, String pin) {
        super (id,name,daya);
        this.lockstatus = lockstatus;
    }

    @Override
    public String status () { 
        return "Status : " + lockstatus;
    }

    @Override 
    public void lock () {
        lockstatus = "Tidak Terkunci";
    }

    @Override
    public String printData() {
        return "Smart Door Lock " + super.printData() + " | Status " + status() +" | PIN : " + pin;
    }
}


public class kuis1 {
    public static void main(String[] args) {
       System.out.println("Smart Home");
        ArrayList<smartHome> device = new ArrayList<>();
        device.add(new smartTV("TV-01", "TV Living Room", 120.0,5,20,"Menyala"));
        device.add(new smartSpeaker("TV-01", "TV Living Room", 120.0,15,"Mati"));
        device.add(new smartDoorLock("TV-01", "TV Living Room", 120.0,"Terkunci","1240"));

         for ( smartHome a : device ) {
        System.out.println(a.printData());
        }
    }

   
}


