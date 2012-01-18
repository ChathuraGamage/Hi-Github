//Auther Chathura
import java.util.LinkedList;
import java.io.*;
public class Census
{
    private static house house1;

    public static void main(String[] args)throws IOException
    {
        Database DB=new Database();
        mobiledevice device=new mobiledevice(001);

        person person1=new person("Perera","54697V","Male","Engineer","40","Sinhala","Buddhist");
        person person2=new person("Silva","12354V","Male","Doctor","45","Sinhala","Buddhist");
        person person3=new person("Rajesh","45789V","Male","Teacher","42","Tamil","Hindu");

        device.addpersons(person1);
        device.addpersons(person2);                                     //add persons details to the mobile device
        device.addpersons(person3);

        device.userInput();                                             //Get user inputs and add person details to the mobile device

	{

        house house1=new house("Colombo",2);


        house1.setOwner("12354V");
        house1.addmembersID("12546V");
        house1.addmembersID("54698V");
        house1.setWorth(1000000.00f);
        house1.setDes("one floor house");
        }

        device.addhouse(house1);                                            //add house details to the mobile device
        {
        vehicle vehicle1=new vehicle("C56528","Car");

        vehicle1.setOwner("54697V");
        vehicle1.setWorth(1500000.0f);
        vehicle1.setDes("Toyota");

        device.addvehicle(vehicle1);                                        //add vehicles details to the mobile device
        }
        {
            workplace workplace1=new workplace("Unicorn (pvt)ltd","Nugegoda",30);

            workplace1.setOwner("45789V");
            workplace1.setDes("Software");
            workplace1.setWorth(1500000.0f);
            workplace1.addWorkersID("43256v");

            device.addworkplace(workplace1);                                //add workplaces details to the mobile device
        }
        {
            land land1=new land("Moratuwa");

            land1.setOwner("45789V");
            land1.setDes("10 square meter cultivate land");
            land1.setWorth(2200000.0f);

            device.addland(land1);                                          //add lands details to the mobile device
        }

        {
            industry industry1=new industry("unix (pvt) Ltd","Clothing",300);

            industry1.setOwner("21567V");
            industry1.setDes("Garment produce clothes");
            industry1.setWorth(13400000.0f);

            device.addindustry(industry1);                                  //add industry details to the mobile device
        }



        DB.adddevice(device);                                     //Add a mobile device to the database
        DB.storedata(0);                                         //update database with the datas of the first mobile device

        System.out.println("Number of people : "+DB.persons.size());
        System.out.println("********Details of the people********");
         System.out.println("\n");
        DB.showPerson();                                        //print the details about persons
        DB.updateReport();                                      // print the report about person in a text file
        // As above this can get all the details about the houses,workplaces,vehicles,lands,industries stored in the database

    }
}

class person
{
   private String name;
   private String gender;
   private String ID;
   private String age;
   private String relationshipStatus;
   private String occupation;
   private String highEduLev;
   private String nationality;
   private String religion;
   private float monthlyIncome;

   person(String _name,String _ID,String _gender,String _occ,String _age,String _nation,String _rel)
    {
       name=_name;
       ID=_ID;
       gender=_gender;
       occupation=_occ;
       age=_age;
       nationality=_nation;
       religion=_rel;
   }

   String getName()
    {
       return name;
   }

   String getID()
    {
       return ID;
   }
   String getGender()
    {
       return gender;
   }
   String getOccupation()
    {
       return occupation;
   }

   String getAge()
    {
       return age;
   }

   String getNationality()
    {
       return nationality;

   }

   String getReligion()
    {
       return religion;
   }


}

 class assests
 {
        private String ownerID;
        private float worth;
        private String description;


        void setOwner(String _owner)
        {
            ownerID=_owner;
        }

        void setWorth(float wr)
        {
            worth=wr;
        }

        void setDes(String des)
        {
               description=des;
        }

       String getOwner()
        {
            return ownerID;
        }

       String getDes()
     {
           return description;
       }

       float getWorth()
       {
           return worth;
       }




}

class house extends assests
    {
            private String address;
            private int noFmembers;
            LinkedList membersID=new LinkedList();

            house (String add,int no)
            {
                address=add;
                noFmembers=no;
            }

            void addmembersID(String man)
            {
                    membersID.add(man);
            }

            String getAdr()
            {
                return address;
            }

            int getNFM()
            {
                    return noFmembers;
            }

            LinkedList getmembers()
            {
                return membersID;
            }
    }

class workplace extends assests{

    private String name;
    private String address;
    private int noFW;
    LinkedList workersID=new LinkedList();

    workplace(String _name,String adr,int nfw)
    {
        name=_name;
        address=adr;
        noFW=nfw;
    }

    void addWorkersID(String wrk){

        workersID.add(wrk);
    }

    LinkedList getWorkers()
    {
        return workersID;
    }

    String getName()
    {
        return name;
    }

    String getAdd()
    {
        return address;
    }

    int noFW()
    {
        return noFW;
    }
}

class land extends assests{

    private String location;

    land(String ln){
        location=ln;
    }

    String getLoc()
    {
        return location;
    }
}

class industry extends assests{

    private String name;
    private String type;
    private int WF;

    industry(String nm,String typ,int wf){
        name=nm;
        type=typ;
        WF=wf;
    }

    String getName()
    {
        return name;
    }

    String getType()
    {
        return type;
    }

    int getWF()
    {
        return WF;
    }

}

class vehicle extends assests{

    private String VIP;
    private String type;

    vehicle(String vp,String typ)
    {
        VIP=vp;
        type=typ;
    }

    String getVIP()
    {
        return VIP;
    }

    String getType()
    {
        return type;
    }
}

class mobiledevice{

    private int index;
    LinkedList<person> persons=new LinkedList<person>();
    LinkedList<house> houses=new LinkedList<house>();
    LinkedList<workplace> workplaces=new LinkedList<workplace>();
    LinkedList<land> lands=new LinkedList<land>();
    LinkedList<vehicle> vehicles=new LinkedList<vehicle>();
    LinkedList<industry> industrys=new LinkedList<industry>();

    mobiledevice(int no)
    {
        index=no;
    }

    void addpersons(person man)
    {
        persons.add(man);
    }

    void addhouse(house hm)
    {
        houses.add(hm);
    }

    void addworkplace(workplace wp)
    {
        workplaces.add(wp);
    }

    void addland(land ln)
    {
        lands.add(ln);
    }

    void addvehicle(vehicle vc)
    {
        vehicles.add(vc);
    }

    void addindustry(industry ind)
    {
        industrys.add(ind);
    }

    LinkedList getperson()
    {
        return persons;
    }

    LinkedList gethouse()
    {
        return houses;
    }

    LinkedList getworkplace()
    {
        return workplaces;
    }

    LinkedList getlands()
    {
        return lands;
    }
    LinkedList getvehicle()
    {
        return vehicles;
    }
    LinkedList getindustry()
    {
        return industrys;
    }

    void userInput()
    {
        BufferedReader read=new BufferedReader(new InputStreamReader(System.in));

        try{
            System.out.println("Number of person would you like to add : ");
            int n=Integer.parseInt(read.readLine());

            for(int i=1;i<=n;i++)
            {
                System.out.println("Name : ");
                String name=read.readLine();
                System.out.println("ID : ");
                String id=read.readLine();						//Get input and store in the mobile device
                System.out.println("Gender : ");
                String gender=read.readLine();
                System.out.println("Occupation : ");
                String occ=read.readLine();
                System.out.println("Age : ");
                String age=read.readLine();
                System.out.println("Nationality : ");
                String nat=read.readLine();
                System.out.println("Religion : ");
                String rel=read.readLine();

                person pr=new person(name,id,gender,occ,age,nat,rel);
                persons.add(pr);
            }

        }catch(IOException n)
        {
            System.out.println("Error");
        }
    }
}

class Database
{
    LinkedList<mobiledevice> device=new LinkedList<mobiledevice>();
    LinkedList<person> persons=new LinkedList<person>();
    LinkedList<house> houses=new LinkedList<house>();
    LinkedList<workplace> workplaces=new LinkedList<workplace>();
    LinkedList<land> lands=new LinkedList<land>();
    LinkedList<vehicle> vehicles=new LinkedList<vehicle>();
    LinkedList<industry> industrys=new LinkedList<industry>();


    void adddevice(mobiledevice md)
    {
        device.add(md);
    }

    void storedata(int i)
    {
        mobiledevice MD=device.get(i);

        LinkedList<person> prs=MD.getperson();
        prs.size();
       int j;
        for( j=0;j<prs.size();j++)
        {

            persons.add(prs.get(j));

        }

        LinkedList<house> hs=MD.gethouse();
        int k;

        for(k=0;k<hs.size();k++)
        {
            houses.add(hs.get(k));

        }

        LinkedList<workplace> wp=MD.getworkplace();

       for(k=0;k<wp.size();k++)
       {
           workplaces.add(wp.get(k));

       }

        LinkedList<land> lnd=MD.getlands();

        for(j=0;j<lnd.size();j++)
        {
            lands.add(lnd.get(j));

        }

        LinkedList<vehicle> vh=MD.getvehicle();

        for(j=0;j<vh.size();j++)
        {
            vehicles.add(vh.get(j));

        }

        LinkedList<industry> ind=MD.getindustry();

        for(k=0;k<ind.size();k++)
        {
            industrys.add(ind.get(k));

        }

    }

    void showPerson()
    {
        for(int i=0;i<persons.size();i++)
        {
            System.out.println("Name : "+ persons.get(i).getName());
            System.out.println("ID : "+ persons.get(i).getID());
            System.out.println("Gender : "+ persons.get(i).getGender());
            System.out.println("Occupation : "+persons.get(i).getOccupation());
            System.out.println("Age : "+ persons.get(i).getAge());
            System.out.println("Nationality : "+ persons.get(i).getNationality());
            System.out.println("Religion : "+ persons.get(i).getReligion());
            System.out.println("\n");
        }
    }

    void updateReport()throws IOException
    {
        PrintWriter wrt=new PrintWriter(new BufferedWriter(new FileWriter("F:\\Level 1 Semester2\\OOP\\Census.txt")));

        wrt.println("Number of people : "+persons.size());
        wrt.println("********Details of the people********");
        for(int i=0;i<persons.size();i++)
        {

            wrt.println("Name : "+ persons.get(i).getName());
            wrt.println("ID : "+ persons.get(i).getID());
            wrt.println("Gender : "+ persons.get(i).getGender());
            wrt.println("Occupation : "+persons.get(i).getOccupation());
            wrt.println("Age : "+ persons.get(i).getAge());
            wrt.println("Nationality : "+ persons.get(i).getNationality());
            wrt.println("Religion : "+ persons.get(i).getReligion());
            wrt.println("\n");

        }
        wrt.close();
    }


}

