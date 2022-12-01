<template>
  <div>
    <h1>Title : {{ book.title }}</h1>
    <h1>Author : {{ book.author }}</h1>
    <h1>isbn : {{ book.isbn }}</h1>
    <button @click="deleteBook">DELETE</button>
    <hr />
  </div>
</template>

<script>
import axios from "axios";

export default {
  name: "MyBook",
  props: {
    book: Object,
  },
  created() {
    console.log(this.book);
  },
  methods: {
    deleteBook() {
      axios({
        method: "delete",
        url: "http://localhost:8080/bookapi/book/" + this.book.isbn,
        headers: {
          "Content-type": "application/json",
        },
      }).then((res) => {
        console.log(res.data);
        this.$emit("delete");
      });
    },
  },
};
</script>

<style></style>
