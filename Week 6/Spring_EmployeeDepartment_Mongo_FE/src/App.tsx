import { RouterProvider } from "react-router-dom";
import { router } from "./routers";
import { ScrollArea } from "./components/ui/scroll-area";

function App() {
  return (
    <ScrollArea className="min-h-screen">
      <RouterProvider router={router}></RouterProvider>
    </ScrollArea>
  );
}

export default App;
