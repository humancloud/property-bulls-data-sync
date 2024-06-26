package com.property.sync_data.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.List;

@Entity
@Table(name = "properties")
@Data
public class Property {

    @Id
    @JsonProperty("ListingKey")
    @Column(name = "listing_key")
    private String listingKey;

    @JsonProperty("ListingId")
    @Column(name = "listing_id")
    private String listingId;

    @JsonProperty("PropertyType")
    @Column(name = "Property_type")
    private String propertyType;

    @JsonProperty("PropertySubType")
    @Column(name = "Property_sub_type")
    private String propertySubType;

    @JsonProperty("StandardStatus")
    @Column(name = "standard_status")
    private String standardStatus;

    @JsonProperty("ModificationTimestamp")
    @Column(name = "modification_timestamp")
    private OffsetDateTime modificationTimestamp;

    @JsonProperty("ListPrice")
    @Column(name = "list_price")
    private Double listPrice;

    @JsonProperty("LivingArea")
    @Column(name = "living_area")
    private Long livingArea;

    @JsonProperty("City")
    @Column(name = "city")
    private String city;

    @JsonProperty("PostalCode")
    @Column(name = "postal_code")
    private String postalCode;

    @JsonProperty("UnparsedAddress")
    @Column(name = "unparsed_address")
    private String unparsedAddress;

    @JsonProperty("Coordinates")
    @Column(name = "coordinate", columnDefinition = "double precision[]")
    private List<Double> coordinates;

    @JsonProperty("Latitude")
    @Column(name = "latitude")
    private Double latitude;

    @JsonProperty("Longitude")
    @Column(name = "longitude")
    private Double longitude;

    @JsonProperty("YearBuilt")
    @Column(name = "year_built")
    private Long yearBuilt;

    @JsonProperty("InternetAddressDisplayYN")
    @Column(name = "internet_address_display_yn")
    private Boolean internetAddressDisplayYN;

    @JsonProperty("FeedTypes")
    @Column(name = "feed_types")
    private String feedTypes;

    @JsonProperty("ListAgentFullName")
    @Column(name = "list_agent_full_name")
    private String listAgentFullName;

    @JsonProperty("ListOfficeName")
    @Column(name = "list_office_name")
    private String listOfficeName;

    @JsonProperty("ListAgentMlsId")
    @Column(name = "list_agent_mls_id")
    private String listAgentMlsId;

    @JsonProperty("ListOfficeMlsId")
    @Column(name = "list_office_mls_id")
    private String listOfficeMlsId;

    @JsonProperty("OriginatingSystemName")
    private String originatingSystemName;

    @JsonProperty("PublicRemarks")
    @Column(name = "public_remarks", columnDefinition = "TEXT")
    private String publicRemarks;

    @JsonProperty("AssociationFeeIncludes")
    @Column(name = "association_fee_includes", columnDefinition = "text[]")
    private List<String> associationFeeIncludes;

    @JsonProperty("AssociationFee")
    @Column(name = "association_fee")
    private String associationFee;

    @JsonProperty("AssociationFeeFrequency")
    @Column(name = "association_fee_frequency")
    private String associationFeeFrequency;

    @JsonProperty("Appliances")
    @Column(name = "appliances", columnDefinition = "text[]")
    private List<String> appliances;

    @JsonProperty("AssociationName")
    @Column(name = "association_name")
    private String associationName;

    @JsonProperty("AssociationPhone")
    @Column(name = "association_phone")
    private String associationPhone;

    @JsonProperty("AssociationYN")
    @Column(name = "association_yn")
    private Boolean associationYN;

    @JsonProperty("AtticAccessYN_C")
    @Column(name = "attic_access_yn_c")
    private String atticAccessYN_C;

    @JsonProperty("AtticType_C")
    @Column(name = "attic_type_c")
    private String atticType_C;

    @JsonProperty("BasementBathrooms_C")
    @Column(name = "basement_bedrooms_c")
    private String basementBathrooms_C;

    @JsonProperty("BasesmentSqFt_C")
    @Column(name = "basesment_sq_ft_c")
    private String basesmentSqFt_C;

    @JsonProperty("BathroomsFull")
    @Column(name = "bathrooms_full")
    private String bathroomsFull;

    @JsonProperty("BrokerWebYN_C")
    @Column(name = "broker_web_yn_c")
    private String brokerWebYN_C;

    @JsonProperty("BuildingAreaSource")
    @Column(name = "building_area_source")
    private String buildingAreaSource;

    @JsonProperty("BuildingAreaUnits")
    @Column(name = "building_area_units")
    private String buildingAreaUnits;

    @JsonProperty("BuyerAgencyCompensation")
    @Column(name = "buyer_agency_compensation")
    private String buyerAgencyCompensation;

    @JsonProperty("class_name")
    @Column(name = "class_name")
    private String className;

    @JsonProperty("CoListAgent2Key_C")
    @Column(name = "co_list_agent2_key_c")
    private String coListAgent2Key_C;

    @JsonProperty("CommercialType_C")
    @Column(name = "commercial_type_c")
    private String commercialType_C;

    @JsonProperty("CommunityFeatures")
    @Column(name = "community_features", columnDefinition = "text[]")
    private List<String> communityFeatures;

    @JsonProperty("ConstructionMaterials")
    @Column(name = "construction_materials", columnDefinition = "text[]")
    private List<String> constructionMaterials;

    @JsonProperty("Cooling")
    @Column(name = "cooling", columnDefinition = "text[]")
    private List<String> cooling;

    @JsonProperty("Country")
    @Column(name = "country")
    private String country;

    @JsonProperty("CountyOrParish")
    @Column(name = "county_or_parish")
    private String countyOrParish;

    @JsonProperty("CreationDate")
    @Column(name = "creation_date")
    private OffsetDateTime creationDate;

    @JsonProperty("CumulativeDaysOnMarket")
    @Column(name = "cumulative_days_on_market")
    private Long cumulativeDaysOnMarket;

    @JsonProperty("DaysOnMarket")
    @Column(name = "days_on_market")
    private Long daysOnMarket;

    @JsonProperty("DirectionFaces")
    @Column(name = "direction_faces")
    private String directionFaces;

    @JsonProperty("Directions")
    @Column(name = "directions", columnDefinition = "TEXT")
    private String directions;

    @JsonProperty("ElementarySchool")
    @Column(name = "elementary_school")
    private String elementarySchool;

    @JsonProperty("ExteriorFeatures")
    @Column(name = "exterior_features", columnDefinition = "text[]")
    private List<String> exteriorFeatures;

    @JsonProperty("FirstFloorBathYN_C")
    @Column(name = "first_floor_bath_yn_c")
    private String firstFloorBathYN_C;

    @JsonProperty("Flooring")
    @Column(name = "flooring", columnDefinition = "text[]")
    private List<String> flooring;

    @JsonProperty("FoundationDetails")
    @Column(name = "foundation_details", columnDefinition = "text[]")
    private List<String> foundationDetails;

    @JsonProperty("GarageSpaces")
    @Column(name = "garage_spaces")
    private String garageSpaces;

    @JsonProperty("GarageType_C")
    @Column(name = "garage_type_c")
    private String garageType_C;

    @JsonProperty("HamletID_C")
    @Column(name = "hamlet_id_c")
    private String hamletID_C;

    @JsonProperty("HandicapFeaturesYN_C")
    @Column(name = "handicap_features_yn_c")
    private String handicapFeaturesYN_C;

    @JsonProperty("HavePermitYN_C")
    @Column(name = "have_permit_yn_c")
    private String havePermitYN_C;

    @JsonProperty("Heating")
    @Column(name = "heating", columnDefinition = "text[]")
    private List<String> heating;

    @JsonProperty("HiddenDraftYN_C")
    @Column(name = "hidden_draft_yn_c")
    private String hiddenDraftYN_C;

    @JsonProperty("HighSchool")
    private String highSchool;

    @JsonProperty("HorseYN_C")
    @Column(name = "horse_yn_c")
    private String horseYN_C;

    @JsonProperty("InteriorAmps_C")
    @Column(name = "interior_amps_c")
    private String interiorAmps_C;

    @JsonProperty("InteriorFeatures")
    @Column(name = "interior_features", columnDefinition = "text[]")
    private List<String> interiorFeatures;

    @JsonProperty("InternetAutomatedValuationDisplayYN")
    @Column(name = "internet_automated_valuation_yn")
    private Boolean internetAutomatedValuationDisplayYN;

    @JsonProperty("InternetConsumerCommentYN")
    @Column(name = "internet_consumer_comment_yn")
    private Boolean internetConsumerCommentYN;

    @JsonProperty("InternetEntireListingDisplayYN")
    @Column(name = "internet_entire_listing_display_yn")
    private Boolean internetEntireListingDisplayYN;

    @JsonProperty("IsSeasonalYN_C")
    @Column(name = "is_seasonal_yn_c")
    private String isSeasonalYN_C;

    @JsonProperty("KitchenCounterType_C")
    @Column(name = "kitchen_counter_type_c")
    private String kitchenCounterType_C;

    @JsonProperty("KitchenType_C")
    @Column(name = "kitchen_type_c")
    private String kitchenType_C;

    @JsonProperty("LandFrontage_C")
    @Column(name = "land_frontage_c")
    private String landFrontage_C;

    @JsonProperty("LastStatusValue_C")
    @Column(name = "last_status_value_c")
    private String lastStatusValue_C;

    @JsonProperty("Levels")
    @Column(name = "levels", columnDefinition = "text[]")
    private List<String> levels;

    @JsonProperty("ListAgentAOR")
    @Column(name = "list_agent_aor")
    private String listAgentAOR;

    @JsonProperty("ListAgentDirectPhone")
    @Column(name = "list_agent_direct_phone")
    private String listAgentDirectPhone;

    @JsonProperty("ListAgentEmail")
    @Column(name = "list_agent_email")
    private String listAgentEmail;

    @JsonProperty("ListAgentFax")
    @Column(name = "list_agent_fax")
    private String listAgentFax;

    @JsonProperty("ListAgentKey")
    @Column(name = "list_agent_key")
    private String listAgentKey;

    @JsonProperty("ListAgentPager")
    @Column(name = "list_agent_pager")
    private String listAgentPager;

    @JsonProperty("ListAOR")
    @Column(name = "list_aor")
    private String listAOR;

    @JsonProperty("ListingAgreement")
    @Column(name = "listing_agreement")
    private String listingAgreement;

    @JsonProperty("ListingContractDate")
    @Column(name = "listing_contract_date")
    private String listingContractDate;

    @JsonProperty("ListOfficeFax")
    @Column(name = "list_office_fax")
    private String listOfficeFax;

    @JsonProperty("ListOfficeKey")
    private String listOfficeKey;

    @JsonProperty("ListOfficePhone")
    @Column(name = "list_office_phone")
    private String listOfficePhone;

    @JsonProperty("LivingAreaSource")
    @Column(name = "living_area_source")
    private String livingAreaSource;

    @JsonProperty("LotSizeAcres")
    @Column(name = "lot_size_acres")
    private Double lotSizeAcres;

    @JsonProperty("LotSizeSquareFeet")
    @Column(name = "lot_size_square_feet")
    private Long lotSizeSquareFeet;

    @JsonProperty("MiddleOrJuniorSchool")
    @Column(name = "middle_or_junior_school")
    private String middleOrJuniorSchool;

    @JsonProperty("MlgCanUse")
    @Column(name = "mlg_can_use", columnDefinition = "text[]")
    private List<String> mlgCanUse;

    @JsonProperty("MlgCanView")
    @Column(name = "mlg_can_view")
    private Boolean mlgCanView;

    @JsonProperty("MLSAreaMajor")
    @Column(name = "mls_area_major")
    private String mLSAreaMajor;

    @JsonProperty("MlsName_C")
    @Column(name = "mls_name_c")
    private String mlsName_C;

    @JsonProperty("MlsStatus")
    @Column(name = "mls_status")
    private String mlsStatus;

    @JsonProperty("NearBusYN_C")
    @Column(name = "near_bus_yn_c")
    private String nearBusYN_C;

    @JsonProperty("NearSchoolYN_C")
    @Column(name = "near_school_yn_c")
    private String nearSchoolYN_C;

    @JsonProperty("NearTrainYN_C")
    @Column(name = "near_train_yn_c")
    private String nearTrainYN_C;

    @JsonProperty("NoFeeSplit_C")
    @Column(name = "no_fee_split_c")
    private String noFeeSplit_C;

    @JsonProperty("OccupantType")
    @Column(name = "occupant_type")
    private String occupantType;

    @JsonProperty("OnMarketDate")
    @Column(name = "on_market_date")
    private String onMarketDate;

    @JsonProperty("OriginalEntryTimestamp")
    @Column(name = "original_entry_timestamp")
    private OffsetDateTime originalEntryTimestamp;

    @JsonProperty("OriginalListPrice")
    @Column(name = "original_list_price")
    private Long originalListPrice;

    @JsonProperty("OriginatingSystemKey")
    @Column(name = "originating_system_key")
    private String originatingSystemKey;

    @JsonProperty("Ownership")
    @Column(name = "ownership")
    private String ownership;

    @JsonProperty("ParcelNumber")
    @Column(name = "parcel_number")
    private String parcelNumber;

    @JsonProperty("PercentOfTaxDeductable_C")
    @Column(name = "percent_of_tax_deductible_c")
    private String percentOfTaxDeductable_C;

    @JsonProperty("PetsAllowed")
    @Column(name = "pets_allowed", columnDefinition = "text[]")
    private List<String> petsAllowed;

    @JsonProperty("PhotoModificationTimestamp_C")
    @Column(name = "photo_modification_timestamp_c")
    private OffsetDateTime photoModificationTimestamp_C;

    @JsonProperty("PhotosChangeTimestamp")
    @Column(name = "photos_change_timestamp")
    private OffsetDateTime photosChangeTimestamp;

    @JsonProperty("PhotosCount")
    @Column(name = "photos_count")
    private Integer photosCount;

    @JsonProperty("PoolFeatures")
    @Column(name = "pool_features", columnDefinition = "text[]")
    private List<String> poolFeatures;

    @JsonProperty("PoolPrivateYN")
    @Column(name = "pool_private_yn")
    private Boolean poolPrivateYN;

    @JsonProperty("PostalCodePlus4")
    @Column(name = "postal_code_plus4")
    private String postalCodePlus4;

    @JsonProperty("PostWarBuildingYN_C")
    @Column(name = "post_war_building_yn_c")
    private String postWarBuildingYN_C;

    @JsonProperty("PreWarBuildingYN_C")
    @Column(name = "pre_war_building_yn_c")
    private String preWarBuildingYN_C;

    @JsonProperty("PrivateRemarks")
    @Column(name = "private_remarks", columnDefinition = "TEXT")
    private String privateRemarks;

    @JsonProperty("PublicSurveyRange")
    @Column(name = "public_survey_range")
    private String publicSurveyRange;

    @JsonProperty("PublicSurveySection")
    @Column(name = "public_survey_section")
    private String publicSurveySection;

    @JsonProperty("RenovationYear_C")
    @Column(name = "renovation_year_c")
    private String renovationYear_C;

    @JsonProperty("ResidentialStyle_C")
    @Column(name = "residential_style_c")
    private String residentialStyle_C;

    @JsonProperty("RoadSurfaceType")
    @Column(name = "road_surface_type", columnDefinition = "text[]")
    private List<String> roadSurfaceType;

    @JsonProperty("Roof")
    @Column(name = "roof", columnDefinition = "text[]")
    private List<String> roof;

    @JsonProperty("RoomForGarageYN_C")
    @Column(name = "room_for_garage_yn_c")
    private String roomForGarageYN_C;

    @JsonProperty("RoomForPoolYN_C")
    @Column(name = "room_for_pool_yn_c")
    private String roomForPoolYN_C;

    @JsonProperty("RoomForTennisYN_C")
    @Column(name = "room_for_tennis_yn_c")
    private String roomForTennisYN_C;

    @JsonProperty("SaleOrRent_C")
    @Column(name = "sale_or_rent_c")
    private String saleOrRent_C;

    @JsonProperty("SchoolDistrict_C")
    @Column(name = "school_district_c")
    private String schoolDistrict_C;

    @JsonProperty("Sewer")
    @Column(name = "sewer", columnDefinition = "text[]")
    private List<String> sewer;

    @JsonProperty("ShowingRequirements")
    @Column(name = "showing_requirements", columnDefinition = "text[]")
    private List<String> showingRequirements;

    @JsonProperty("ShowPriceYN_C")
    @Column(name = "show_price_yn_c")
    private String showPriceYN_C;

    @JsonProperty("SouthOfHighwayYN_C")
    @Column(name = "south_of_highway_yn_c")
    private String southOfHighwayYN_C;

    @JsonProperty("StaffBaths_C")
    @Column(name = "staff_baths_c")
    private String staffBaths_C;

    @JsonProperty("StaffBeds_C")
    @Column(name = "staff_beds_c")
    private String staffBeds_C;

    @JsonProperty("StateOrProvince")
    @Column(name = "state_or_province")
    private String stateOrProvince;

    @JsonProperty("SpecialListingConditions")
    @Column(name = "special_listing_conditions", columnDefinition = "text[]")
    private List<String> specialListingConditions;

    @JsonProperty("StatusChangeTimestamp")
    @Column(name = "status_change_timestamp")
    private OffsetDateTime statusChangeTimestamp;

    @JsonProperty("SubdivisionName")
    @Column(name = "subdivision_name")
    private String subdivisionName;

    @JsonProperty("StoriesTotal")
    @Column(name = "stories_total")
    private String storiesTotal;

    @JsonProperty("StreetName")
    @Column(name = "street_name")
    private String streetName;

    @JsonProperty("StreetNumber")
    @Column(name = "street_number")
    private String streetNumber;

    @JsonProperty("StreetSuffix")
    @Column(name = "street_suffix")
    private String streetSuffix;

    @JsonProperty("TaxAnnualAmount")
    @Column(name = "tax_annual_amount")
    private BigDecimal taxAnnualAmount;

    @JsonProperty("TaxBlock")
    @Column(name = "tax_block")
    private String taxBlock;

    @JsonProperty("TaxBookNumber")
    @Column(name = "tax_book_number")
    private String taxBookNumber;

    @JsonProperty("TaxLegalDescription")
    @Column(name = "tax_legal_description")
    private String taxLegalDescription;

    @JsonProperty("TaxLot")
    @Column(name = "tax_lot")
    private String taxLot;

    @JsonProperty("TaxYear")
    @Column(name = "tax_year")
    private String taxYear;

    @JsonProperty("Township")
    @Column(name = "township")
    private String township;

    @JsonProperty("TransactionBrokerCompensation")
    @Column(name = "transaction_broker_compensation")
    private String transactionBrokerCompensation;

    @JsonProperty("UndisclosedAddressYN_C")
    @Column(name = "undisclosed_address_yn_c")
    private String undisclosedAddressYN_C;

    @JsonProperty("UniversalPropertyId")
    @Column(name = "universal_property_id")
    private String universalPrtax_yearopertyId;

    @JsonProperty("Utilities")
    @Column(name = "utilities", columnDefinition = "text[]")
    private List<String> utilities;

    @JsonProperty("WaterSource")
    @Column(name = "water_source", columnDefinition = "text[]")
    private List<String> waterSource;

    @JsonProperty("UtilitiesYN_C")
    @Column(name = "utilities_yn_c")
    private String utilitiesYN_C;

    @JsonProperty("VirtualTourURLUnbranded")
    @Column(name = "virtual_tour_url_unbranded")
    private String virtualTourURLUnbranded;

    @JsonProperty("Zoning")
    @Column(name = "zoning")
    private String zoning;

    @JsonProperty("Media")
    @OneToMany(mappedBy = "property", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Media> media;

}
