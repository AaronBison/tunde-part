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
    <v-select v-model="selectElement" :items="items" backgroundColor="#E1E1DE" item-text="place" item-value="id"
                label="Válaszd ki hová szeretnél menni!" @input="walkingSetUp" dense solo></v-select>

    <model-gltf :lights="vilagitas" @on-click="examp" :backgroundColor="backgroundcolor" :position="cameraPosition" 
        src="static/models/sapi3Dreg.gltf">
    </model-gltf>
    <v-btn class="mx-2" fab dark small color="grey" @click="stepedLeft">
        <v-icon dark>
            far fa-arrow-alt-circle-left
        </v-icon>
    </v-btn>
    <v-btn class="mx-2" fab dark small color="grey" @click="stepedUp">
        <v-icon dark>
            far fa-arrow-alt-circle-up
        </v-icon>
    </v-btn>
    <v-btn class="mx-2" fab dark small color="grey" @click="stepedRight">
        <v-icon dark>
            far fa-arrow-alt-circle-right
        </v-icon>
    </v-btn>
    <v-btn class="mx-2" fab dark small color="grey" @click="stepedDown">
        <v-icon dark>
            far fa-arrow-alt-circle-down
        </v-icon>
    </v-btn>
    <v-btn class="mx-2" fab dark small color="grey" @click="walking">
        <v-icon dark>
            fas fa-walking
        </v-icon>
    </v-btn>
</v-container>
</template>

<script>
import { ModelObj } from "vue-3d-model";
import { ModelCollada } from "vue-3d-model";
import { ModelFbx } from "vue-3d-model";
import { ModelStl } from "vue-3d-model";
import { ModelPly } from "vue-3d-model";
import { ModelGltf } from "vue-3d-model";
// import { OrbitControls } from "three-orbitcontrols"
// import { MglMap, MglGeolocateControl, MglNavigationControl, MglPopup, MglMarker  } from "vue-mapbox/dist/vue-mapbox.umd.js";


export default {
  name: "Model3D",
  components: {
    ModelObj,
    ModelCollada,
    ModelFbx,
    ModelStl,
    ModelPly,
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
		fab: false,
		firstRoadInd: 0,
		items: [
				{place:'Aula', id:'al'},
				{place:'Gépész tanszék', id:'gt'},
				{place:'Gépész labor', id:'gl'},
				{place:'Dékáni hivatal', id:'dh'},
				{place:'Matematika-informatika tanszék', id:'mt'},
			],
		selectElement:{place:'', id:''},
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
				intensity: 2,
			},
			{
				// Direkcionális fény, különböző irányokból
				type: "DirectionalLight",
				position: { x: -1, y: 2, z: -1 },
				color: 0xffd7b8,
				intensity: 3,
			},
			{
				// Direkcionális fény, különböző irányokból
				type: "DirectionalLight",
				position: { x: 1, y: 2, z: -1 },
				color: 0xffd7b8,
				intensity: 3,
			},
			{
				// Direkcionális fény, különböző irányokból
				type: "DirectionalLight",
				position: { x: 0, y: 1, z: 1 },
				color: 0xfffcf2,
				intensity: 3,
			},
		],
		cameraPosition: { x:0, y: 0, z: 0 },
		road: [],
		roadInd: 0,
		aulaRoad:[
			{ x:0.45, y: 8.5, z: 99 },
			{ x:0.45, y: 8.503465, z: 111.14366 },
		],
		gtRoad:[
			{ x:0.45, y: 8.5, z: 99 },
			{ x:0.45, y: 8.503465, z: 111.14366 },
			{ x:9.1286, y: 8.503458, z: 124.451 },
		],
		glRoad:[
			{ x:0.45, y: 8.5, z: 99 },
			{ x:0.45, y: 8.503465, z: 111.14366 },
			{ x:9.1991, y: 8.503465, z: 76.805 }
		],
		dkRoad:[
			{ x:0.45, y: 8.5, z: 99 },
			{ x:0.45, y: 8.503465, z: 111.14366 },
			{ x:9.1286, y: 8.503458, z: 124.451 },
			{ x:-8.7151, y: 4.947, z: 126.409 },
		],
		mtRoad:[
			{ x:0.45, y: 8.5, z: 99 },
			{ x:0.45, y: 8.503465, z: 111.14366 },
			{ x:9.1286, y: 8.503458, z: 124.451 },
			{ x:-8.7151, y: 4.947, z: 126.409 },
			{ x:6.3104, y: 1.397, z: 121.895 },
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
		stepedLeft(){
		// ballra
			this.cameraPosition.x += 1;
		},
		stepedDown(){
		//vissza
			this.cameraPosition.z -= 1;
		},
		walkingSetUp()
		{
			switch (this.selectElement){
				case "al":
					this.road = this.aulaRoad;
					this.roadInd = 0;
					break;
				case "gt":
					this.road = this.gtRoad;
					this.roadInd = 0;
					break;
				case "gl":
					this.road = this.glRoad;
					this.roadInd = 0;
					break;
				case "dh":
					this.road = this.dkRoad;
					this.roadInd = 0;
					break;
				case "mt":
					this.road = this.mtRoad;
					this.roadInd = 0;
					break;
				default:
					this.road = [];
					break;
			}
		},
		walking(){

			if (this.roadInd >= this.road.length)
			{
				this.cameraPosition.x = 0;
				this.cameraPosition.y = 0;
				this.cameraPosition.z = 0;
				this.roadInd = 0;
			}
			else
			{
				this.cameraPosition.x = this.road[this.roadInd].x;
				this.cameraPosition.y = this.road[this.roadInd].y;
				this.cameraPosition.z = this.road[this.roadInd].z;
				this.roadInd++;
			}
		},
		examp(cord){
			console.log(cord.point)
		},
	},
};
</script>