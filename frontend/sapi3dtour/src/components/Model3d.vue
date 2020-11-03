<template>
  <v-container class="justify-center">
    <v-card id="card">
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

      <model-gltf :lights="vilagitas" @on-load="onLoad" :backgroundColor="backgroundcolor" :position="cameraPosition" 
        src="static/models/sapi3D.gltf">
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
    </v-card>
  </v-container>
</template>

<script>
import { ModelObj } from "vue-3d-model";
import { ModelCollada } from "vue-3d-model";
import { ModelFbx } from "vue-3d-model";
import { ModelStl } from "vue-3d-model";
import { ModelPly } from "vue-3d-model";
import { ModelGltf } from "vue-3d-model";
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
    // MglMap, 
    // MglGeolocateControl, 
    // MglNavigationControl,
    // MglPopup, 
    // MglMarker
  },
  data() {
    return {
      fab: false,
      rotation: {
        x: 0,
        y: 0,
        z: 0,
      },
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
      cameraPosition: { x: 0, y: 0, z: 0 },
    };
  },
  methods: {
    onLoad() {
      this.rotate();
    },
    rotate() {
      this.rotation.y -= 0.009;
      requestAnimationFrame(this.rotate);
    },
    stepedUp() {
      //előre
      this.cameraPosition.z += 10;
    },
    stepedRight() {
      //jobbra
      this.cameraPosition.x -= 4;
    },
    stepedLeft(){
      // ballra
      this.cameraPosition.x += 4;
    },
    stepedDown(){
      //vissza
      this.cameraPosition.z -= 4;
    }
  },
};
</script>