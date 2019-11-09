package xyz.deonico.catswiki.model;

import com.google.gson.annotations.SerializedName;

public class ResponseBreed{

	@SerializedName("suppressed_tail")
	private int suppressedTail;

	@SerializedName("cat_friendly")
	private Object catFriendly;

	@SerializedName("wikipedia_url")
	private String wikipediaUrl;

	@SerializedName("origin")
	private String origin;

	@SerializedName("description")
	private String description;

	@SerializedName("experimental")
	private int experimental;

	@SerializedName("characteristic")
	private String characteristic;

	@SerializedName("createdAt")
	private String createdAt;

	@SerializedName("life_span")
	private String lifeSpan;

	@SerializedName("cfa_url")
	private String cfaUrl;

	@SerializedName("rare")
	private int rare;

	@SerializedName("lap")
	private int lap;

	@SerializedName("id")
	private int id;

	@SerializedName("short_legs")
	private int shortLegs;

	@SerializedName("bidability")
	private Object bidability;

	@SerializedName("shedding_level")
	private int sheddingLevel;

	@SerializedName("photo_main")
	private String photoMain;

	@SerializedName("introduction")
	private String introduction;

	@SerializedName("updatedAt")
	private String updatedAt;

	@SerializedName("photo_1")
	private String photo1;

	@SerializedName("photo_2")
	private String photo2;

	@SerializedName("dog_friendly")
	private int dogFriendly;

	@SerializedName("natural")
	private int natural;

	@SerializedName("rex")
	private int rex;

	@SerializedName("health_issues")
	private int healthIssues;

	@SerializedName("hairless")
	private int hairless;

	@SerializedName("weight")
	private String weight;

	@SerializedName("alt_names")
	private String altNames;

	@SerializedName("adaptability")
	private int adaptability;

	@SerializedName("vocalisation")
	private int vocalisation;

	@SerializedName("intelligence")
	private int intelligence;

	@SerializedName("social_needs")
	private int socialNeeds;

	@SerializedName("child_friendly")
	private int childFriendly;

	@SerializedName("vcahospitals_url")
	private String vcahospitalsUrl;

	@SerializedName("temperament")
	private String temperament;

	@SerializedName("name")
	private String name;

	@SerializedName("vetstreet_url")
	private String vetstreetUrl;

	@SerializedName("grooming")
	private int grooming;

	@SerializedName("hypoallergenic")
	private int hypoallergenic;

	@SerializedName("indoor")
	private int indoor;

	@SerializedName("energy_level")
	private int energyLevel;

	@SerializedName("stranger_friendly")
	private int strangerFriendly;

	@SerializedName("affection_level")
	private int affectionLevel;

	@SerializedName("breed")
	private ResponseBreed breed;

	public ResponseBreed(int id, String name, String description, String createdAt, String photo_main) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.createdAt = createdAt;
		this.photoMain = photo_main;
	}

	public void setBreed(ResponseBreed breed){
		this.breed = breed;
	}

	public ResponseBreed getBreed(){
		return breed;
	}

	public void setSuppressedTail(int suppressedTail){
		this.suppressedTail = suppressedTail;
	}

	public int getSuppressedTail(){
		return suppressedTail;
	}

	public void setCatFriendly(Object catFriendly){
		this.catFriendly = catFriendly;
	}

	public Object getCatFriendly(){
		return catFriendly;
	}

	public void setWikipediaUrl(String wikipediaUrl){
		this.wikipediaUrl = wikipediaUrl;
	}

	public String getWikipediaUrl(){
		return wikipediaUrl;
	}

	public void setOrigin(String origin){
		this.origin = origin;
	}

	public String getOrigin(){
		return origin;
	}

	public void setDescription(String description){
		this.description = description;
	}

	public String getDescription(){
		return description;
	}

	public void setExperimental(int experimental){
		this.experimental = experimental;
	}

	public int getExperimental(){
		return experimental;
	}

	public void setCharacteristic(String characteristic){
		this.characteristic = characteristic;
	}

	public String getCharacteristic(){
		return characteristic;
	}

	public void setCreatedAt(String createdAt){
		this.createdAt = createdAt;
	}

	public String getCreatedAt(){
		return createdAt;
	}

	public void setLifeSpan(String lifeSpan){
		this.lifeSpan = lifeSpan;
	}

	public String getLifeSpan(){
		return lifeSpan;
	}

	public void setCfaUrl(String cfaUrl){
		this.cfaUrl = cfaUrl;
	}

	public String getCfaUrl(){
		return cfaUrl;
	}

	public void setRare(int rare){
		this.rare = rare;
	}

	public int getRare(){
		return rare;
	}

	public void setLap(int lap){
		this.lap = lap;
	}

	public int getLap(){
		return lap;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setShortLegs(int shortLegs){
		this.shortLegs = shortLegs;
	}

	public int getShortLegs(){
		return shortLegs;
	}

	public void setBidability(Object bidability){
		this.bidability = bidability;
	}

	public Object getBidability(){
		return bidability;
	}

	public void setSheddingLevel(int sheddingLevel){
		this.sheddingLevel = sheddingLevel;
	}

	public int getSheddingLevel(){
		return sheddingLevel;
	}

	public void setPhotoMain(String photoMain){
		this.photoMain = photoMain;
	}

	public String getPhotoMain(){
		return photoMain;
	}

	public void setIntroduction(String introduction){
		this.introduction = introduction;
	}

	public String getIntroduction(){
		return introduction;
	}

	public void setUpdatedAt(String updatedAt){
		this.updatedAt = updatedAt;
	}

	public String getUpdatedAt(){
		return updatedAt;
	}

	public void setPhoto1(String photo1){
		this.photo1 = photo1;
	}

	public String getPhoto1(){
		return photo1;
	}

	public void setPhoto2(String photo2){
		this.photo2 = photo2;
	}

	public String getPhoto2(){
		return photo2;
	}

	public void setDogFriendly(int dogFriendly){
		this.dogFriendly = dogFriendly;
	}

	public int getDogFriendly(){
		return dogFriendly;
	}

	public void setNatural(int natural){
		this.natural = natural;
	}

	public int getNatural(){
		return natural;
	}

	public void setRex(int rex){
		this.rex = rex;
	}

	public int getRex(){
		return rex;
	}

	public void setHealthIssues(int healthIssues){
		this.healthIssues = healthIssues;
	}

	public int getHealthIssues(){
		return healthIssues;
	}

	public void setHairless(int hairless){
		this.hairless = hairless;
	}

	public int getHairless(){
		return hairless;
	}

	public void setWeight(String weight){
		this.weight = weight;
	}

	public String getWeight(){
		return weight;
	}

	public void setAltNames(String altNames){
		this.altNames = altNames;
	}

	public String getAltNames(){
		return altNames;
	}

	public void setAdaptability(int adaptability){
		this.adaptability = adaptability;
	}

	public int getAdaptability(){
		return adaptability;
	}

	public void setVocalisation(int vocalisation){
		this.vocalisation = vocalisation;
	}

	public int getVocalisation(){
		return vocalisation;
	}

	public void setIntelligence(int intelligence){
		this.intelligence = intelligence;
	}

	public int getIntelligence(){
		return intelligence;
	}

	public void setSocialNeeds(int socialNeeds){
		this.socialNeeds = socialNeeds;
	}

	public int getSocialNeeds(){
		return socialNeeds;
	}

	public void setChildFriendly(int childFriendly){
		this.childFriendly = childFriendly;
	}

	public int getChildFriendly(){
		return childFriendly;
	}

	public void setVcahospitalsUrl(String vcahospitalsUrl){
		this.vcahospitalsUrl = vcahospitalsUrl;
	}

	public String getVcahospitalsUrl(){
		return vcahospitalsUrl;
	}

	public void setTemperament(String temperament){
		this.temperament = temperament;
	}

	public String getTemperament(){
		return temperament;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setVetstreetUrl(String vetstreetUrl){
		this.vetstreetUrl = vetstreetUrl;
	}

	public String getVetstreetUrl(){
		return vetstreetUrl;
	}

	public void setGrooming(int grooming){
		this.grooming = grooming;
	}

	public int getGrooming(){
		return grooming;
	}

	public void setHypoallergenic(int hypoallergenic){
		this.hypoallergenic = hypoallergenic;
	}

	public int getHypoallergenic(){
		return hypoallergenic;
	}

	public void setIndoor(int indoor){
		this.indoor = indoor;
	}

	public int getIndoor(){
		return indoor;
	}

	public void setEnergyLevel(int energyLevel){
		this.energyLevel = energyLevel;
	}

	public int getEnergyLevel(){
		return energyLevel;
	}

	public void setStrangerFriendly(int strangerFriendly){
		this.strangerFriendly = strangerFriendly;
	}

	public int getStrangerFriendly(){
		return strangerFriendly;
	}

	public void setAffectionLevel(int affectionLevel){
		this.affectionLevel = affectionLevel;
	}

	public int getAffectionLevel(){
		return affectionLevel;
	}

	@Override
 	public String toString(){
		return 
			"ResponseBreed{" + 
			"suppressed_tail = '" + suppressedTail + '\'' + 
			",cat_friendly = '" + catFriendly + '\'' + 
			",wikipedia_url = '" + wikipediaUrl + '\'' + 
			",origin = '" + origin + '\'' + 
			",description = '" + description + '\'' + 
			",experimental = '" + experimental + '\'' + 
			",characteristic = '" + characteristic + '\'' + 
			",createdAt = '" + createdAt + '\'' + 
			",life_span = '" + lifeSpan + '\'' + 
			",cfa_url = '" + cfaUrl + '\'' + 
			",rare = '" + rare + '\'' + 
			",lap = '" + lap + '\'' + 
			",id = '" + id + '\'' + 
			",short_legs = '" + shortLegs + '\'' + 
			",bidability = '" + bidability + '\'' + 
			",shedding_level = '" + sheddingLevel + '\'' + 
			",photo_main = '" + photoMain + '\'' + 
			",introduction = '" + introduction + '\'' + 
			",updatedAt = '" + updatedAt + '\'' + 
			",photo_1 = '" + photo1 + '\'' + 
			",photo_2 = '" + photo2 + '\'' + 
			",dog_friendly = '" + dogFriendly + '\'' + 
			",natural = '" + natural + '\'' + 
			",rex = '" + rex + '\'' + 
			",health_issues = '" + healthIssues + '\'' + 
			",hairless = '" + hairless + '\'' + 
			",weight = '" + weight + '\'' + 
			",alt_names = '" + altNames + '\'' + 
			",adaptability = '" + adaptability + '\'' + 
			",vocalisation = '" + vocalisation + '\'' + 
			",intelligence = '" + intelligence + '\'' + 
			",social_needs = '" + socialNeeds + '\'' + 
			",child_friendly = '" + childFriendly + '\'' + 
			",vcahospitals_url = '" + vcahospitalsUrl + '\'' + 
			",temperament = '" + temperament + '\'' + 
			",name = '" + name + '\'' + 
			",vetstreet_url = '" + vetstreetUrl + '\'' + 
			",grooming = '" + grooming + '\'' + 
			",hypoallergenic = '" + hypoallergenic + '\'' + 
			",indoor = '" + indoor + '\'' + 
			",energy_level = '" + energyLevel + '\'' + 
			",stranger_friendly = '" + strangerFriendly + '\'' + 
			",affection_level = '" + affectionLevel + '\'' + 
			"}";
		}
}