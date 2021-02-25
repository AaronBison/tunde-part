<template>
  <v-container class="justify-center">
    <!-- OBJ -->
    <!-- <model-obj
        :rotation="rotation"
        @on-load="onLoad"
        :lights="vilagitas"
        src="static/models/lowpoly_well.obj"
        mtl="static/models/lowpoly_well.mtl"
      ></model-obj> -->

    <!-- DAE -->
    <!-- <model-collada
        :rotation="rotation"
        @on-load="onLoad"
        :lights="vilagitas"
        src="static/models/lowpoly_well.dae"
      ></model-collada>-->

    <!-- FBX -->
    <!-- <model-fbx
        :rotation="rotation"
        @on-load="onLoad"
        src="static/models/lowpoly_well.fbx"
        mtl="static/models/lowpoly_well.mtl"
      ></model-fbx>-->

    <!-- STL -->
    <!-- <model-stl
        :rotation="rotation"
        @on-load="onLoad"
        src="static/models/lowpoly_well.stl"
        mtl="static/models/lowpoly_well.mtl"
      ></model-stl>-->

    <!-- PLY -->
    <!-- <model-ply
        :rotation="rotation"
        @on-load="onLoad"
        src="static/models/lowpoly_well.ply"
        mtl="static/models/lowpoly_well.mtl"
      ></model-ply>-->
    <v-select
      v-model="selectElement"
      :items="items"
      backgroundColor="#E1E1DE"
      item-text="place"
      item-value="id"
      label="Válaszd ki hová szeretnél menni!"
      @input="walkingSetUp"
      dense
      solo
    ></v-select>

    <model-gltf
      height=600
      width=1138
      :lights="vilagitas"
      @on-click="examp"
      :backgroundColor="backgroundcolor"
      :position="cameraPosition"
      :cameraPosition="angle"
      src="static/models/sapi3D.gltf?"
    >
    </model-gltf>
    <v-btn class="mx-2" fab dark small color="grey" @click="stepedLeft">
      <v-icon dark> far fa-arrow-alt-circle-left </v-icon>
    </v-btn>
    <v-btn class="mx-2" fab dark small color="grey" @click="stepedUp">
      <v-icon dark> far fa-arrow-alt-circle-up </v-icon>
    </v-btn>
    <v-btn class="mx-2" fab dark small color="grey" @click="stepedRight">
      <v-icon dark> far fa-arrow-alt-circle-right </v-icon>
    </v-btn>
    <v-btn class="mx-2" fab dark small color="grey" @click="stepedDown">
      <v-icon dark> far fa-arrow-alt-circle-down </v-icon>
    </v-btn>
    <v-btn
      v-if="walkingBottunDis == false"
      class="mx-2"
      fab
      dark
      small
      color="grey"
      @click="walkingWithAnimation"
    >
      <v-icon dark> fas fa-walking </v-icon>
    </v-btn>
    <v-btn
      v-if="walkingBottunDis"
      class="mx-2"
      disabled
      fab
      dark
      small
      color="grey"
    >
      <v-icon dark> fas fa-walking </v-icon>
    </v-btn>
  </v-container>
</template>

<script>
// import { ModelObj } from "vue-3d-model";
// import { ModelCollada } from "vue-3d-model";
// import { ModelFbx } from "vue-3d-model";
// import { ModelStl } from "vue-3d-model";
// import { ModelPly } from "vue-3d-model";
import { ModelGltf } from "vue-3d-model";
// import { OrbitControls } from "three-orbitcontrols"
// import { MglMap, MglGeolocateControl, MglNavigationControl, MglPopup, MglMarker  } from "vue-mapbox/dist/vue-mapbox.umd.js";

export default {
  name: "Model3D",
  components: {
    // ModelObj,
    // ModelCollada,
    // ModelFbx,
    // ModelStl,
    // ModelPly,
    ModelGltf,
    // OrbitControls
    // MglMap,
    // MglGeolocateControl,
    // MglNavigationControl,
    // MglPopup,
    // MglMarker
  },
  data() {
    return {
      enableZoom: false,
      fab: false,
      firstRoadInd: 0,
      walkingBottunDis: true,
      items: [
        { place: "Aula", id: "al" },
        { place: "Gépész tanszék", id: "gt" },
        { place: "Gépész labor", id: "gl" },
        { place: "Dékáni hivatal", id: "dh" },
        { place: "Matematika-informatika tanszék", id: "mt" },
      ],
      selectElement: { place: "", id: "" },
      // rotation: {
      //   x: 0,
      //   y: 0,
      //   z: 0,
      // },
      backgroundcolor: "rgb(225, 225, 222)",
      vilagitas: [
        // x - jobbról
        // y - felülről
        // z - hátulról
        {
          // Álltalános fényerő az egész mezőn
          type: "HemisphereLight",
          position: { x: 0, y: 1, z: 0 },
          skyColor: 0xffd7b8,
          groundColor: 0x000000,
          intensity: 0,
        },
        {
          // Direkcionális fény, különböző irányokból
          type: "DirectionalLight",
          position: { x: -1, y: 2, z: -1 },
          color: 0xffd7b8,
          intensity: 2,
        },
        {
          // Direkcionális fény, különböző irányokból
          type: "DirectionalLight",
          position: { x: 1, y: 2, z: -1 },
          color: 0xffd7b8,
          intensity: 2,
        },
        {
          // Direkcionális fény, különböző irányokból
          type: "DirectionalLight",
          position: { x: 0, y: 1, z: 1 },
          color: 0xfffcf2,
          intensity: 2,
        },
      ],
      cameraPosition: { x: 0, y: 0, z: -60 },
      angle: { x: 0, y: 0, z: 0.1 },
	  speed: 10,
	  stepScale: 0.5, 
      road: [],
      roadInd: 0,
      markers: [
        {
          name: "startDoor",
          coordinates: { x: 0, y: 15, z: -15 },
        },
        {
          name: "aula",
          coordinates: { x: 0, y: 15, z: 8 },
        },
        {
          name: "geptan",
          coordinates: { x: 9, y: 15, z: 22 },
        },
        {
          name: "geplab",
          coordinates: { x: 9, y: 15, z: -26 },
        },
        {
          name: "dekhiv",
          coordinates: { x: -8, y: 11, z: 22 },
        },
        {
          name: "mattan",
          coordinates: { x: 7, y: 7.5, z: 19 },
        },
      ],
      aula: [{ el: "startDoor" }, { el: "aula" }],
      geptan: [{ el: "startDoor" }, { el: "aula" }, { el: "geptan" }],
      geplab: [{ el: "startDoor" }, { el: "aula" }, { el: "geplab" }],
      dekhiv: [
        { el: "startDoor" },
        { el: "aula" },
        { el: "geptan" },
        { el: "dekhiv" },
      ],
      mattan: [
        { el: "startDoor" },
        { el: "aula" },
        { el: "geptan" },
        { el: "dekhiv" },
        { el: "mattan" },
      ],
    };
  },
  methods: {
    stepedUp() {
      //előre
      this.cameraPosition.z += 1;
    },
    stepedRight() {
      //jobbra
      this.cameraPosition.x -= 1;
    },
    stepedLeft() {
      // ballra
      this.cameraPosition.x += 1;
    },
    stepedDown() {
      //vissza
      this.cameraPosition.z -= 1;
    },
    roadUpload(array) {
      this.markers.forEach((element) => {
        array.forEach((element1) => {
          if (element.name == element1.el) {
            this.road.push(element.coordinates);
          }
        });
      });
    },
    walkingSetUp() {
      this.roadInd = 0;

      switch (this.selectElement) {
        case "al":
          this.walkingBottunDis = false;
          this.road = [];
          this.roadUpload(this.aula);
          break;
        case "gt":
          this.walkingBottunDis = false;
          this.road = [];
          this.roadUpload(this.geptan);
          break;
        case "gl":
          this.walkingBottunDis = false;
          this.road = [];
          this.roadUpload(this.geplab);
          break;
        case "dh":
          this.walkingBottunDis = false;
          this.road = [];
          this.roadUpload(this.dekhiv);
          break;
        case "mt":
          this.walkingBottunDis = false;
          this.road = [];
          this.roadUpload(this.mattan);
          break;
        default:
          this.walkingBottunDis = true;
          this.road = [];
          break;
      }

      this.cameraPosition.x = this.road[this.roadInd].x;
      this.cameraPosition.y = this.road[this.roadInd].y;
      this.cameraPosition.z = this.road[this.roadInd].z;
    },

    sleep(milliseconds) {
      const date = Date.now();
      let currentDate = null;
      do {
        currentDate = Date.now();
      } while (currentDate - date < milliseconds);
    },

    // Megnezi, hogy novelnie vagy csokkentenie kell a koordinatat, hogy kozeledjen a celhoz
    stepCloser(start,destination){
      if(start == destination){
        return start
      }else{
        if(start < destination){
          return start += this.stepScale 
        }else{
          return start -= this.stepScale
        }
      }
    },

    async animation(destination) {
      // Disable-eli a gombot mig az animacio folyik, bugmegelozes celjabol
      this.walkingBottunDis = true
      // Addig kozeledik a koordinatakhoz, amig a kezdopont es a cel meg nem egyezik
    	while (Object.entries(this.cameraPosition).toString() !== Object.entries(destination).toString()) {
        this.cameraPosition.x = this.stepCloser(this.cameraPosition.x,destination.x)
        this.cameraPosition.y = this.stepCloser(this.cameraPosition.y,destination.y)
        this.cameraPosition.z = this.stepCloser(this.cameraPosition.z,destination.z)
			  await new Promise(r => setTimeout(r, this.speed));
      }
      this.walkingBottunDis = false
    },

    walkingWithAnimation() {
      if (this.roadInd < this.road.length - 1) {
        
		    // Atvezeto animacio a ket egymasutani pont kozott
        this.animation(this.road[this.roadInd + 1]);
        this.roadInd++;

      } else {
        this.roadInd = 0;
        this.cameraPosition.x = this.road[this.roadInd].x;
        this.cameraPosition.y = this.road[this.roadInd].y;
        this.cameraPosition.z = this.road[this.roadInd].z;
      }

    },

    walkingWithWarping() {
      if (this.roadInd < this.road.length) {

        // Lepteti a road tombon, amig el nem er a vegere.
        this.cameraPosition.x = this.road[this.roadInd].x;
        this.cameraPosition.y = this.road[this.roadInd].y;
        this.cameraPosition.z = this.road[this.roadInd].z;
        this.roadInd++;
      } else {

        // Visszateszi az elso pozicioba s kezdodik elolrol
        this.roadInd = 0;
        this.cameraPosition.x = this.road[this.roadInd].x;
        this.cameraPosition.y = this.road[this.roadInd].y;
        this.cameraPosition.z = this.road[this.roadInd].z;
        this.roadInd++;
      }
    },
    examp(cord) {
      console.log(cord.point);
    },
  },
  mounted()
    {
		var tmp = this.$route.query.road;
		if(tmp != undefined)
		{
			this.selectElement = tmp;
			this.walkingSetUp();
		}
    }
};
</script>