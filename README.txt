Project 3 - CSCI 8350 - Ontology Engineering

Topic: Information about Tamil Cuisine

Brief Description: This ontology covers an overview of different kinds of food that originated from Tamil Nadu, southernmost state of India. The Knowledge base covers the information about various dishes, its main ingredient, flavor, Method of Cooking, regional origination within Tamil Nadu and so on. This ontology provides an overall information about the Traditional Tamil cuisine. This can be further devised into choosing menu for the day for restaurants based on main ingredients available or can be used for suggesting menu to customer queries who are not aware of this particular cuisine or it can be used to represent their own cuisine by adding individuals as per the region.  

Protege Version:
                 This ontology is created using the beta version and few DL Queries on the Instances was issued to check for the inconsistencies and corrected accordingly.

 
(i) Classes:

The classes were identified using combination method - Top down and Bottom Up. This ontology consists a total of 28 classes that are built into the hierarchy as listed below with a brief description about each class.

1. Food - Different kinds of dishes separated by its characteristics.

   1.a. Main Course - This class represents the main course dishes that are common in Tamil Cuisine.
        1.a.1. Dry Dish - This class is a sub class of Main course which represents the main course which are in form of dry texture.
        1.a.2. Gravy Dish - This class is a sub class of Main course which represents the main course which are in form of watery/gravy texture.
   1.b. Side Dish - This class represents the appetizers that are common in Tamil Cuisine.
        1.b.1. Varuval - This class represents the appetizers those are prepared by means of Roasting.
        1.b.2. Thovaiyal - This class represents the appetizers those are prepared by means of Grinding.
        1.b.3. Aviyal - This class represents the appetizers those are prepared by means of Boiling.
        1.b.4. Poriyal - This class represents the appetizers those are prepared by means of stir-fried.
   1.c. Soup - This class represents the soup that are common in Tamil Cuisine.
   1.d. Dessert - This class represents the desserts that are common in Tamil Cuisine.
   1.e. Snacks - This class represents the snacks that are common in Tamil Cuisine.
   1.f. Beverage - This class represents the drinks that are common in Tamil Cuisine.


2. Ingredient - This class represents the different kinds of ingredients which plays a vital role in the preparation of Tamil Cuisine.

   2.a. Main Ingredient - This class represents the main ingredients that are used in Tamil Cuisine.
        2.a.1. Meat - This class represents the different kinds of meat used in Tamil Cuisine.
        2.a.2. Cereals - This class represents the different kinds of cereals used in Tamil Cuisine.
        2.a.3. Vegetables - This class represents the different kinds of vegetables used in Tamil Cuisine.
        2.a.4. Fish - This class represents the different kinds of fish used in Tamil Cuisine.
               2.a.4.a. Sea Fish - This class represents the different kinds of sea fish used in Tamil Cuisine.
               2.a.4.b. Fresh Water Fish - This class represents the different kinds of fresh water fish used in Tamil Cuisine.
               2.a.4.c. Dried Fish - This class represents the different kinds of dried fish used in Tamil Cuisine.
               2.a.4.d. Shell Fish - This class represents the different kinds of shell fish used in Tamil Cuisine.
   2.b. Side Ingredient - This class represents the supplementary ingredients used in Tamil cuisine. 
        2.b.1. Spices - This class represents the different kinds of spices used in Tamil Cuisine.
        2.b.2. Masala - This class represents the different kinds of masala used in Tamil Cuisine.
        2.b.3. Oil - This class represents the different kinds of oils used in Tamil Cuisine.
        2.b.4. Herbs - This class represents the different kinds of herbs used in Tamil Cuisine.

(ii) Properties:

Data Type Properties:

1. hasTechnique - This property relates the type of technique involved in preparing the Food via one of the enumerated values.

  Domain: Food
  Range:  Deep Fried, Boiled, Baked, Steamed, Sautéed, Stewed.

2. hasFlavor - This property defines the flavor of the Food.

  Domain: Ingredients
  Range: Sweet, Sour, Bitter, Savory, Salty

3. isOfDiet - This property represents the diet type of food.

  Domain: Food
  Range: Non-Vegetrian, Vegan, Vegetarian

4. isOfRegion - The property regional lists the information about a dish if it belongs to a special region of Tamil Nadu. 

  Domain: Food
  Range: Chettinad, Kongu, Nellai, Madurai

5. isServedAt - This property defines the meal that may be served as particular time of the day. 

  Domain: Food
  Range: Breakfast, Lunch, Dinner, Breaktime Snacks

6. hasAtOccasion - The property defines the occurrence of the food dish.

  Domain: Food
  Range: Everyday, Festive, Seasonal

7. hasNoOfIngredients - This property lists the total number of ingredients needed for the food preparation. It must be a non-negative integer.

  Domain: Food
  Range: Non negative integer

8. isUsedAs - This property defines whether the dish can be served as Side Dish or Main Course.

  Domain: Food
  Range: Side Dish, Main Course


Object Type Properties: 

1. consists_of - This property defines the main ingredient of the associated food. 

  Domain: Food
  Range: Ingredient 

2. mustContain - This property states that the Main course class and its sub classes must contain at least an individual from one of the Main Ingredient Classes.

  Domain: Main Course
  Range: Main_Ingredient

3. hasatleast - This property defines that the main course must consists of at least one individual from Gravy Dish and Dry Dish.
  
  Domain: Main Course
  Range: Dry Dish and Gravy Dish

4. goesWith - This property provides the suggestions between the Main Course and Side Dish Classes.

  Domain: Main Course, Side Dish
  Range: Side Dish, Main Course

5. isUsedIn - This property defines the ingredient used in which Food. 

  Domain: Ingredient
  Range: Food



(iii) Cardinality Functions: 

1. Minimum cardinality is set to 1 for Data Type Property - hasNoOfIngredients.
2. A Food will be considered Main Course only if it contains an individual of the Ingredient Class.
3. Food listed under Side dish cannot be listed under Main Course.
4. Within Side dish category, an individual can either be Dry dish or Gravy dish.


