package com.example.composeapp.domain.model


import com.google.gson.annotations.SerializedName

data class Response(
    @SerializedName("problems")
    val problems: List<Problem>
)
data class Problem(
    @SerializedName("Asthma")
    val asthma: List<Asthma>,
    @SerializedName("Diabetes")
    val diabetes: List<Diabete>
)

class Asthma

data class Diabete(
    @SerializedName("labs")
    val labs: List<Lab>,
    @SerializedName("medications")
    val medications: List<Medication>
)

data class Medication(
    @SerializedName("medicationsClasses")
    val medicationsClasses: List<MedicationsClasse>
)

data class MedicationsClasse(
    @SerializedName("className")
    val className: List<ClassName>,
    @SerializedName("className2")
    val className2: List<ClassName2>
)

data class ClassName(
    @SerializedName("associatedDrug")
    val associatedDrug: List<AssociatedDrug>,
    @SerializedName("associatedDrug#2")
    val associatedDrug2: List<AssociatedDrug>
)

data class ClassName2(
    @SerializedName("associatedDrug")
    val associatedDrug: List<AssociatedDrug>,
    @SerializedName("associatedDrug#2")
    val associatedDrug2: List<AssociatedDrug>
)

data class AssociatedDrug(
    @SerializedName("dose")
    val dose: String,
    @SerializedName("name")
    val name: String, // asprin
    @SerializedName("strength")
    val strength: String // 500 mg
)
data class Lab(
    @SerializedName("missing_field")
    val missingField: String // missing_value
)
