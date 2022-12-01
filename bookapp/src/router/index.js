import Vue from "vue";
import VueRouter from "vue-router";
import ListView from "../views/ListView.vue";
import CreateView from "../views/CreateView.vue";

Vue.use(VueRouter);

const routes = [
  {
    path: "/",
    name: "list",
    component: ListView,
  },
  {
    path: "/create",
    name: "create",
    component: CreateView,
  },
];

const router = new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  routes,
});

export default router;
