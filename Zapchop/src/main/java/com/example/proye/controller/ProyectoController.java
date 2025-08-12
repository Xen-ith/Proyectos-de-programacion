package com.example.proye.controller;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.proye.model.calzado;
import com.example.proye.model.carrito_pedido;
import com.example.proye.model.cliente;
import com.example.proye.model.pedido;
import com.example.proye.model.venta;
import com.example.proye.repository.calzadoRepository;
import com.example.proye.repository.carrito_pedidoRepository;
import com.example.proye.repository.clienteRepository;
import com.example.proye.repository.pedidoRepository;
import com.example.proye.repository.ventaRepository;

import jakarta.servlet.http.HttpSession;



@Controller
public class ProyectoController {
  
    @Autowired
    private calzadoRepository calzadoRepository;

    @Autowired
    private clienteRepository clienteRepository;

    @Autowired
    private ventaRepository ventaRepository;

    @Autowired
    private carrito_pedidoRepository carrito_pedidoRepository;

    @Autowired
    private pedidoRepository pedidoRepository;


    @PostMapping("/generar-venta")
    public String generarVenta(@RequestParam("carritoId") Long carritoId, HttpSession session) {
        cliente usuario = (cliente) session.getAttribute("usuario");

        if (usuario == null) {
            return "redirect:/Login";
        }

        Optional<carrito_pedido> carritoOpt = carrito_pedidoRepository.findById(carritoId);

        if (carritoOpt.isPresent()) {
            carrito_pedido carrito = carritoOpt.get();

            pedido nuevoPedido = new pedido();
            nuevoPedido.setCalzado(carrito.getCalzado());
            nuevoPedido.setColor1(carrito.getColor1());
            nuevoPedido.setColor2(carrito.getColor2());
            nuevoPedido.setCordon(carrito.getCordon());
            nuevoPedido.setTalla(carrito.getTalla());
            nuevoPedido.setDescripcion(carrito.getDescripcion());
            nuevoPedido.setCliente(carrito.getCliente());

            pedidoRepository.save(nuevoPedido);

            venta nuevaVenta = new venta();
            nuevaVenta.setPedido(nuevoPedido);
            nuevaVenta.setFecha(java.time.LocalDate.now());

            ventaRepository.save(nuevaVenta);

            carrito_pedidoRepository.deleteById(carritoId);
        }

        return "redirect:/Carrito";
    }

    @RequestMapping("/")
    public String menuPrincipal(Model model) {
        List<calzado> lista = calzadoRepository.findAll();
        model.addAttribute("calzados", lista);
        model.addAttribute("calzado", new calzado());
        model.addAttribute("zapatos", calzadoRepository.findAll());
        return "MenuPrincipal";
    }

    
    @PostMapping("/loginusuario")
    public String loginUSR(Model model, @RequestParam String correo, @RequestParam String contraseña, HttpSession session) {
        if (correo.equals("admin") && contraseña.equals("seguridad")) {
            model.addAttribute("calzado", new calzado());
            return "redirect:/adminMenu";
        } else {
            for (cliente c : clienteRepository.findAll()) {
                if (c.getCorreo().equals(correo) && c.getContraseña().equals(contraseña)) {
                    session.setAttribute("usuario", c);
                    return "redirect:/";
                }
            }
            return "nU";
        }
    }

    @PostMapping("/salirPag")
    public String salirSis(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }

    @GetMapping("/salir")
    public String salir(HttpSession session) {
        cliente usuario = (cliente) session.getAttribute("usuario");
        return (usuario == null) ? "hola" : "salir";
    }

    @PostMapping("/registrarZapato")
public String registrarZAP(@ModelAttribute calzado calzado, HttpSession session) {
        calzadoRepository.save(calzado);
        return "redirect:/";
    }

    @GetMapping("/adminProducto")
    public String adminProductos(Model model, @ModelAttribute calzado calzado) {
        return "admin_crearProducto";
    }

    @GetMapping("/adminMenu")
    public String adminMenu(Model model) {
        return "admin_menu";
    }

    @GetMapping("/adminPedidos")
    public String adminPedidos(Model model, @ModelAttribute pedido pedido) {
        model.addAttribute("ventas", ventaRepository.findAll());
        return "admin_pedidos";
    }
    

    @RequestMapping("/Login")
    public String login(Model model, HttpSession session) {
        cliente usuario = (cliente) session.getAttribute("usuario");
        if(usuario == null){
            return "Login";
        }else{
            model.addAttribute("usuario", usuario);
            return "vistaUSR";
        }
    }

    @RequestMapping("/Registro")
    public String registro(Model model) {
        model.addAttribute("cliente", new cliente());
        model.addAttribute("clientes", clienteRepository.findAll());
        return "Registro";
    }

    @PostMapping("/registrarusuario")
    public String registrarUSR(@ModelAttribute cliente cliente) {
        clienteRepository.save(cliente);
        return "redirect:/Login";
    }

    @GetMapping("/Carrito")
    public String mostrarCarrito(HttpSession session, Model model) {
    cliente usuario = (cliente) session.getAttribute("usuario");
    if (usuario == null) {
        return "redirect:/Login";
    }

    List<carrito_pedido> pedidosUsuario = carrito_pedidoRepository.findByClienteId(usuario.getId());

    model.addAttribute("zapatos", pedidosUsuario);

    return "Carrito";
}


    @GetMapping("/detalles/{id}")
public String mostrarDetalles(@PathVariable int id, Model model) {
    venta venta = ventaRepository.findById(id).orElse(null);
    if (venta != null) {
        model.addAttribute("venta", venta);
    } else {
        model.addAttribute("error", "Venta no encontrada");
    }
    return "detalles";
}

    @GetMapping("/personalizar")
public String perso(@RequestParam("idCalzado") Long idCalzado, HttpSession session, Model model) {
    cliente usuario = (cliente) session.getAttribute("usuario");

    if (usuario == null) {
        return "redirect:/Login";
    }

    Optional<calzado> calzadoOpt = calzadoRepository.findById(idCalzado);
    if (calzadoOpt.isEmpty()) {
        return "redirect:/";
    }

    carrito_pedido nuevoPedido = new carrito_pedido();
    nuevoPedido.setCliente(usuario);
    nuevoPedido.setCalzado(calzadoOpt.get());

    model.addAttribute("pedido", nuevoPedido);
    model.addAttribute("modelo", calzadoOpt.get().getModelo());

    return "usr_pedirCalzado"; 
}

@PostMapping("/pedidoZapato")
public String guardarPedido(@ModelAttribute carrito_pedido pedidoForm) {
    Optional<cliente> clienteOpt = clienteRepository.findById(pedidoForm.getCliente().getId());
    Optional<calzado> calzadoOpt = calzadoRepository.findById(pedidoForm.getCalzado().getId());

    if (clienteOpt.isPresent() && calzadoOpt.isPresent()) {
        cliente cliente = clienteOpt.get();
        calzado calzado = calzadoOpt.get();

        if (calzado.getStock() > 0) {

            calzado.setStock(calzado.getStock() - 1);
            calzadoRepository.save(calzado); 

            pedidoForm.setCliente(cliente);
            pedidoForm.setCalzado(calzado);

            carrito_pedidoRepository.save(pedidoForm);

            return "redirect:/Carrito";
        }
    }
    return "redirect:/";
}
}

