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

    <model-gltf :lights="vilagitas" @on-click="examp" :backgroundColor="backgroundcolor" :position="cameraPosition" :cameraPosition="angle" src="static/models/sapi3D.gltf?">
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
    <v-btn v-if="walkingBottunDis == false" class="mx-2"  fab dark small color="grey" @click="walking">
        <v-icon dark>
            fas fa-walking
        </v-icon>
    </v-btn>
	<v-btn v-if="walkingBottunDis" class="mx-2" disabled fab dark small color="grey">
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
	props: ["roadParam"],
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
			walkingBottunDis:true,
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
			cameraPosition: { x:0, y:0, z:-60},
			angle: { x:0, y:0, z:0.1 },
			road: [],
			roadInd: 0,
			markers:[
				{
					name:"start",
					coordinates: { x:0, y: 15, z: -15 }
				},
				{
					name:"startDoor",
					coordinates:{ x:0, y: 15, z: -15 }
				},
				{
					name:"aula",
					coordinates:{ x:0, y: 15, z: 8 }
				},
				{
					name:"geptan",
					coordinates:{  x:9, y:15, z: 22 }
				},
				{
					name:"geplab",
					coordinates:{  x:9, y:15, z: -26 }
				},
				{
					name:"dekhiv",
					coordinates:{  x:-8, y:11, z: 22 }
				},
				{
					name:"mattan",
					coordinates:{  x:7, y: 7.3, z: 19 }
				}
			],
			aula:[{el:"startDoor"},{el:"aula"}],
			geptan:[{el:"startDoor"},{el:"aula"},{el:"geptan"}],
			geplab:[{el:"startDoor"},{el:"aula"},{el:"geplab"}],
			dekhiv:[{el:"startDoor"},{el:"aula"},{el:"geptan"},{el:"dekhiv"}],
			mattan:[{el:"startDoor"},{el:"aula"},{el:"geptan"},{el:"dekhiv"},{el:"mattan"}]
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
		roadUpload(array)
		{
			this.markers.forEach(element => {
				array.forEach(element1 => {
					if (element.name == element1.el)
					{
						this.road.push(element.coordinates);
					}
				});
			});
		},
		walkingSetUp()
		{
			switch (this.selectElement){
				case "al":
					this.walkingBottunDis = false;
					this.road=[];
					this.roadUpload(this.aula);
					this.roadInd = 0;
					break;
				case "gt":
					this.walkingBottunDis = false;
					this.road=[];
					this.roadUpload(this.geptan);
					this.roadInd = 0;
					break;
				case "gl":
					this.walkingBottunDis = false;
					this.road=[];
					this.roadUpload(this.geplab);
					this.roadInd = 0;
					break;
				case "dh":
					this.walkingBottunDis = false;
					this.road=[];
					this.roadUpload(this.dekhiv);
					this.roadInd = 0;
					break;
				case "mt":
					this.walkingBottunDis = false;
					this.road=[];
					this.roadUpload(this.mattan);
					this.roadInd = 0;
					break;
				default:
					this.walkingBottunDis = true;
					this.road = [];
					break;
			}
		},
		sleep(milliseconds) {
			const date = Date.now();
			let currentDate = null;
			do {
				currentDate = Date.now();
			} while (currentDate - date < milliseconds);
		},
		cordCompre(cord1, cord2)
		{
			if(cord1 <= cord2)
			{
				cord1++;
				if(cord1 > cord2) return cord2;
				else return cord1;
			}
			if(cord1 >= cord2)
			{
				cord1--;
				if(cord1 <= cord2) return cord2;
				else return cord1;
			}
		},
		annimation(lastCord, newCord)
		{
			console.log("lastCord: " + lastCord.x + " " + lastCord.y + " " + lastCord.z);
			console.log("newtCord: " + newCord.x + " " + newCord.y + " " + newCord.z);
			while(true)
			{
				lastCord.x = this.cordCompre(lastCord.x, newCord.x)
				lastCord.y = this.cordCompre(lastCord.y, newCord.y)
				lastCord.z = this.cordCompre(lastCord.z, newCord.z)
				this.cameraPosition.x = lastCord.x;
				this.cameraPosition.y = lastCord.y;
				this.cameraPosition.z = lastCord.z;
				console.log(this.cameraPosition.x+ " " + this.cameraPosition.y + " " + this.cameraPosition.z)
				if(lastCord.x == newCord.x && lastCord.y == newCord.y && lastCord.z == newCord.z)
				{
					break;
				}
			}
			this.walkingBottunDis = true;
		},
		walking1(){
			if (this.roadInd >= this.road.length)
			{
				this.roadInd = 0;
				this.cameraPosition.x = 0;
				this.cameraPosition.y = 0;
				this.cameraPosition.z = 0;	
			}
			else
			{
				if(this.roadInd !=0)
				{
					this.walkingBottunDis = false;
					this.annimation(this.road[this.roadInd-1],this.road[this.roadInd]);
				}
				else
				{
					this.cameraPosition.x = this.road[this.roadInd].x;
					this.cameraPosition.y = this.road[this.roadInd].y;
					this.cameraPosition.z = this.road[this.roadInd].z;
				}
				this.roadInd++;
			}
		},
		walking(){

			if (this.roadInd >= this.road.length)
			{
				this.roadInd = 0;
				this.cameraPosition.x = this.road[this.roadInd].x;
				this.cameraPosition.y = this.road[this.roadInd].y;
				this.cameraPosition.z = this.road[this.roadInd].z;
				this.roadInd++;
			}
			else
			{
				this.walkingBottunDis = true;
				// this.sleep(5000);
				this.cameraPosition.x = this.road[this.roadInd].x;
				this.cameraPosition.y = this.road[this.roadInd].y;
				this.cameraPosition.z = this.road[this.roadInd].z;
				this.roadInd++;
				this.walkingBottunDis = false;
			}
		},
		examp(cord){
			console.log(cord.point)
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