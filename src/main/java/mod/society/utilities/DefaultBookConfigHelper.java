package mod.society.utilities;

public enum DefaultBookConfigHelper
{
    ALCHEMIST(
            "book_alchemist",
            new String[]{
                    
            },
            "Alchemist book"
    ),
    ANIMAL_BREEDER(
            "book_animal_breeder",
            new String[]{
                    
            },
            "Animal breeder book"
    ),
    BLACKSMITH(
            "book_blacksmith",
            new String[]{
                    
            },
            "Blacksmith book"
    ),
    BAKER(
            "book_baker",
            new String[]{
                    
            },
            "Baker book"
    ),
    BUTCHER(
            "book_butcher",
            new String[]{
                    
            },
            "Butcher book"
    ),
    BARKEEPER(
            "book_barkeeper",
            new String[]{
                    
            },
            "Barkeeper book"
    ),
    BURNER(
            "book_burner",
            new String[]{
                    
            },
            "Burner book"
    ),
    CARPENTER(
            "book_carpenter",
            new String[]{
                    
            },
            "Carpenter book"
    ),
    CONFECTIONER(
            "book_confectioner",
            new String[]{
                    
            },
            "Confectioner book"
    ),
    COOK(
            "book_cook",
            new String[]{
                    
            },
            "Cook book"
    ),
    DIGGER(
            "book_digger",
            new String[]{
                    
            },
            "Digger book"
    ),
    FISH_COOK(
            "book_fish_cook",
            new String[]{
                    
            },
            "Fish cook book"
    ),
    FISHER(
            "book_fisher",
            new String[]{
                    
            },
            "Fisher book"
    ),
    FARMER(
            "book_farmer",
            new String[]{
                    
            },
            "Farmer book"
    ),
    GLAZIER(
            "book_glazier",
            new String[]{
                    
            },
            "Glazier book"
    ),
    HEALER(
            "book_healer",
            new String[]{
                    
            },
            "Healer book"
    ),
    ICE_CREAM_MAKER(
            "book_ice_cream_maker",
            new String[]{
                    
            },
            "Ice Cream Maker book"
    ),
    LUMBERJACK(
            "book_lumberjack",
            new String[]{
                    
            },
            "Lumberjack book"
    ),
    LIBRARIAN(
            "book_librarian",
            new String[]{
                    
            },
            "Librarian book"
    ),
    PLANT_BREEDER(
            "book_plant_breeder",
            new String[]{
                    
            },
            "Plant Breeder book"
    ),
    STONEMASON(
            "book_stonemason",
            new String[]{
                    
            },
            "Stonemason book"
    ),
    TREE_REFINER(
            "book_tree_refiner",
            new String[]{
                    
            },
            "Tree refiner book"
    ),
    TAILOR(
            "book_tailor",
            new String[]{
                    
            },
            "Tailor book"
    ),
    TOOLMAKER(
            "book_toolmaker",
            new String[]{
                    
            },
            "Toolmaker book"
    );
    
    private String id;
    private String[] skills;
    private String comment;
    
    DefaultBookConfigHelper(String id, String[] skills, String comment)
    {
        this.id = id;
        this.skills = skills;
        this.comment = comment;
    }

    public String getId()
    {
        return id;
    }

    public String[] getSkills()
    {
        return skills;
    }

    public String getComment()
    {
        return comment;
    }
}
