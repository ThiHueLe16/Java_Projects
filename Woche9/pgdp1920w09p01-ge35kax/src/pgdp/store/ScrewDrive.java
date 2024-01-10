/*package pgdp.store;

public enum ScrewDrive {
//    @Override
//    public abstract String toString();
	/*SlotDrive ("schlitz"),Cross ("kreuzschlitz"),Hex ("sechskant"),Torx ("torx");
	
	private String name;
	//Konstruktor
	private ScrewDrive(String name){
		this.name=name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public String toString() {
		return this.name;
	}
	
	public static void main(String[]args) {
		System.out.println(Cross.toString());
	}
	
}*/

package pgdp.store;

public enum ScrewDrive {
    SlotDrive {
        @Override
        public String toString() {
            return "schlitz";
        }
    },
    Cross {
        @Override
        public String toString() {
            return "kreuzschlitz";
        }
    },
    Hex {
        @Override
        public String toString() {
            return "sechskant";
        }
    },
    Torx {
        @Override
        public String toString() {
            return "torx";
        }
    };

    @Override
    public abstract String toString();
    public static void main(String[]args) {}
}
