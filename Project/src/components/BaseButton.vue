<template>
  <button
    :button="type"
    class="w-full py-2 text-white bg-blue-600 rounded-lg hover:bg-blue-700 focus:outline-none focus:ring-2 focus:ring-blue-500"
    @click="handleClick"
  >
    <slot />
  </button>
</template>

<script setup lang="ts">
import { defineProps, defineEmits } from 'vue'

defineProps({
  type: {
    type: String,
    default: 'button', // Tipo do botão (button, submit, reset)
  },
})

const emit = defineEmits(['click'])

const handleClick = (event: Event) => {
  emit('click', event)
}
</script>
