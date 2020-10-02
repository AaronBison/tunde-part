<template>
  <v-container>
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

      <model-gltf :lights="vilagitas" @on-load="onLoad" :backgroundColor="backgroundcolor"
        src="static/models/aula_scratch.gltf" ></model-gltf>
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
// import * as THREE from 'three'

export default {
  name: "Model3D",
  components: {
    ModelObj,
    ModelCollada,
    ModelFbx,
    ModelStl,
    ModelPly,
    ModelGltf,
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
  },
};
</script>